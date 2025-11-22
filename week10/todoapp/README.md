# Model vs RedirectAttributes
## 1. Model
* **forward 방식(View 렌더링)** 에서만 사용된다.
* 같은 요청 안에서만 데이터를 전달함
* Thymeleaf는 Model의 데이터를 바로 읽어서 화면에 출력함

### Model의 동작 방식

```
Client -> Controller -> View 렌더링
```
* 컨트롤러에서 `model.addAttribute()`로 저장
* **forward**되기 때문에 같은 요청에서 view가 Model을 읽음

```java
@GetMapping
public String todos(Model model) {
	List<TodoDto> todos = todoRepository.findAll();
	model.addAttribute("todos", todos);
	return "todos";
}
```
* Model 유효 -> 타임리프에서 `todos` 접근 가능

---
## RedirectAttributes
* 리다이렉트(redirect:) 할 때 데이터 전달용
* redirect는 새로운 요청을 보내기 때문에 Model이 그대로 전달되지 않는다.
* RedirectAttributes는 redirect 상황에서만 사용된다.

### RedirectAttributes 종류

1. `addAttribute(key, value)`
	* URL 쿼리 파라미터로 전달된다.
	* 실제 URL : `/todos?message=추가됨`

2. `addFlashAttribute(key, value)`
	* 임시 세션에 저장된다.
	* redirect 이후 한번의 요청에만 Model로 전달된다.
	* 사용 후 자동으로 삭제됨

```java
redirectAttributes.addFlashAttribute("message", "Todo를 추가했습니다.");
return "redirect:/todos";
```
* redirect 후 `/todos`가 호출될 때 -> `message`가 모델에 자동으로 포함된다.

---
## 3. redirect에서 Model 안 되는 이유
#### redirect 동작
```
POST /todos
 -> redirect
GET /todos (새로운 요청)
```
* forward(직접 렌더링)이 아니라 **클라이언트가 새로운 요청을 다시 보내기 때문에 이전 모델이 사라진다.**
* 따라서 redirect에서는 model.addAttribute()가 무의미함


> Model은 forward에서만 유효하다.
> redirect에서는 Model이 전달되지 않기 때문에 RedirectAttributes를 사용해야 한다.   
> redirect 이후 화면에 보이는 데이터는 redirect된 컨트롤러가 DB에서 다시 조회한 Model이다.

---
# 단일 책임 원칙(SRP) - `TodoController` -> `TodoService`를 호출하도록 변경
> `TodoController` : 웹 요청과 응답 책임   
> `TodoService` : 비즈니스 로직 책임   
> `TodoRepository` : 데이터 저장/조회 책임   

## Before After 비교
#### Before
```java
@GetMapping("/{id}/toggle")
public String toggle(@PathVariable Long id) {
	// 컨트롤러가 직접 데이터 조회, 상태 변경, 저장 모두 처리함
	TodoDto todo = todoRepository.findById(id).orElseThrow(...);
	todo.setCompleted(!todo.isCompleted());
	todoRepository.save(todo);
	return "redirect:/todos/" + id;
}
```

#### After
```java
private final TodoService todoService; // 서비스 주입 받음

@GetMapping("/{id}/toggle")
public String toggle(@PathVariable Long id) {
	// 비즈니스 로직을 서비스에 위임하고 결과만 처리함
	todoService.toggleCompleted(id);
	return "redirect:/todos/" + id;
}

```

> 컨트롤러는 `toggleCompleted` 비즈니스 로직이 어떻게 동작하는지 알 필요가 없고, 서비스를 호출하기만 하면 된다. -> 책임 분리

## TodoService

``` java
@Service  
public class TodoService {  
  
    private final TodoRepository todoRepository;

	// 토글 비즈니스 로직 서비스에서 수행
	public void toggleCompleted(Long id) {  
	    TodoDto todo = getTodoById(id);  
	    todo.setCompleted(!todo.isCompleted());  
	    todoRepository.save(todo);  
	}  

	// 제목 유효성 검사 비즈니스 로직
	private void validateTitle(String title) {  
	    if (title == null || title.trim().isEmpty()) {  
	        throw new IllegalArgumentException("제목은 필수입니다.");  
	    }  
	  
	    if (title.length() > 50) {  
	        throw new IllegalArgumentException("제목은 50자를 초과할 수 없습니다.");  
	    }  
	}
}
```
* 비즈니스 로직 중앙화
	* `toggleCompleted`, `validateTitle`처럼 여러 곳에서 필요할 수 있는 로직이 `Service` 클래스에 모여있어 재사용하기 좋고 관리하기 편하다.
* 테스트 용이성
	* `TodoService`만 독립적으로 테스트해 애플리케이션의 핵심 로직을 검증할 수 있다.

## DTO와 Entity 분리
* **Entity는 DB와의 관계**, **DTO는 데이터 전달** 이라는 각자의 책임에만 집중할 수 있다.
* 데이터베이스 테이블 구조(엔티티)가 변경되어도 DTO를 사용하면 외부(Controller, View)에 미치는 영향을 최소화할 수 있다.
	* DB에 password 필드가 있어도 DTO에는 포함시키지 않아 외부에 노출되는 것을 막을 수 있음

---
# 엔티티 수정(Todo 수정) 시 update() 메서드 추가
## 엔티티(Entity)에 `update()` 메서드를 작성한 이유
* dto -> Entity -> 엔티티 내부에서 상태 변경을 책임지게 함

### 1. 엔티티는 도메인의 핵심 모델
* Entity = DB 테이블을 나타내는 객체도 맞지만 해당 데이터의 비즈니스 규칙과 상태를 표현하는 객체로 봐야 한다고 판단
* 즉, **데이터 + 데이터가 지켜야 할 규칙**을 함께 갖는 것이 좋은 설계

### 2. 서비스에 로직이 많아지면 생기는 문제 
#### DTO -> Entity 변환이나 업데이트를 서비스에서 처리하면
#### (1) 낮은 응집도
* 데이터가 가진 규칙을 데이터 바깥에서 처리하면 책임이 분산된다.
* Entity의 값이 어떻게 바뀌어야 하는지 서비스가 알아야만 함

#### (2) 코드 중복 발생
* 다른 서비스/기능에서도 같은 방식으로 업데이트해야 하면 매번 동일한 코드가 반복된다.

#### (4) 변경에 취약
* Entity 필드가 변경되면
	* 서비스의 로직도 변경되어야 하고
	* 여러 서비스에서 같은 변경을 반복해야 한다.

### 3. 엔티티가 자기 자신의 상태 변경을 책임짐
* 엔티티 내부에 아래처럼 `update()` 메서드를 둔다.
```java
public void update(String title, boolean completed) {
	this.title = title;
	this.completed = completed;
}

public void update(TodoDto dto) {
	this.title = dto.getTitle();
	this.completed = dto.getCompleted;
}
```

### 4. 엔티티에 update()가 있을 때 장점
#### (1) 응집도 증가 (`변경은 그 객체가 책임짐`)
* TodoEntity 내부에서 Todo의 상태를 변경, 검증한다.
* 서비스는 단순히 `entity.update(dto)`만 호출하면 된다.

#### (2) 중복 제거
* 다른 기능에서 같은 엔티티를 수정해도 update() 만 호출하면 된다.

#### (3) 변경에 강해짐 (유지보수성 높아짐)
* title -> name으로 변경됐을 때 
	* 서비스는 아무것도 몰라도 된다.
	* update() 내부만 고치면 전체 기능이 자동으로 업데이트됨
* 즉, DTO 변경 -> Entity 업데이트만 수정 -> 전체 코드 자동 반영

#### (4) 객체지향의 핵심 `캡슐화` 실천
* 서비스가 엔티티 내부 구조를 몰라도 된다.
```java
// 전
entity.setTitle(dto.title());
entity.setCompleted(dto.completed());

// 후
entity.update(dto);
```
* 서비스는 **어떻게** 바뀌는지는 몰라도 되고, **바뀌어야 한다**는 의도만 표현한다 -> **책체지향적임**

### 요약
> 1. 데이터의 상태 변경은 해당 데이터(엔티티)가 책임져야 한다.
> 2. 서비스에서 값 세팅을 하면 응집도가 떨어진다.
> 3. 엔티티에 update()를 두어서 로직 중복과 변경 취약성을 해결할 수 있다.
> 4. 엔티티가 비즈니스 규칙을 가질 수 있어 객체지향에 맞음
> 5. DTO는 요청/응답 전용으로 순수하게 유지한다.
> 6. update 메서드 하나로 모든 상태 변경을 캡슐화한다.
> 
> * 즉, 서비스는 엔티티를 조작하는 것이 아니라, 엔티티에 **변경**을 요청한다.
> * 덕분에 책임 분리가 선명해지고 유지보수성이 좋아짐

