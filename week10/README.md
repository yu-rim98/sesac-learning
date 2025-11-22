## 스프링(Spring)이란?
> 자바 엔터프라이즈 개발을 단순화하기 위한 경량 프레임워크이다.   
> 스프링은 애플리케이션의 객체 생성, 관리, 연결, 생명주기를 자동으로 관리해줘서 개발자가 복잡한 설정에서 벗어나 로직에 집중할 수 있도록 도와준다.

## 제어의 역전과 의존성 주입
### 1. 제어의 역전(Inversion of Control)
#### 개념
* 원래는 개발자가 코드 안에서 직접 객체를 생성하고 관리(`new TodoRepository()`)했지만 스프링에서는 스프링 컨테이너가 대신 **객체의 생성, 관리, 소멸**을 책임진다.
* 객체 관리의 **제어 권한이 역전**되었다고 해서 IoC라고 부른다.

#### 스프링 컨테이너
* IoC를 담당하는 핵심 요소로 애플리케이션의 모든 객체(Bean)를 담고 관리하는 공간이다.

### 2. 의존성 주입(Dependency Injection, DI)
#### 개념
* IoC를 구현하는 방식으로 한 객체가 다른 객체를 필요로 할 때(의존성을 가질 때) 직접 생성하지 않고 스프링 컨테이너로부터 **주입**받는다.

#### 장점
* 느슨한 결합(Loose Coupling)
	* 각 클래스가 독립적으로 존재할 수 있어 테스트와 유지보수가 쉬워진다.
* 재사용성 증가
	* 필요한 곳 어디에서든 객체를 주입받아 재사용할 수 있다.

--- 
## `todoapp` 에 적용된 스프링 개념
### 1. 스프링 부트 애플리케이션의 시작점
```java
@SpringBootApplication   // 1)
public class TodoappApplication {  
  
    public static void main(String[] args) {  
        SpringApplication.run(TodoappApplication.class, args); // 2)
    }  
  
    @Bean // 3)
    public CommandLineRunner init(TodoRepository todoRepository) {  
      ...
    }  
}
```
1. `@SpringBootApplication `
	* 해당 클래스가 스프링 부트 애플리케이션의 메인 클래스임을 나타낸다.
	* 해당 어노테이션를 붙여주면 여러 자동 설정이 이루어짐
2. `SpringApplication.run(...)`
	* 해당 코드를 통해 내장 웹 서버(톰캣)가 실행되고 스프링 컨테이너가 생성된다.
3. `@Bean`
	* 개발자가 직접 제어하기 힘든 외부 라이브러리나 초기 설정이 필요한 객체를 스프링 컨테이너에 등록할 때 사용한다.
	* 해당 코드에서는 애플리케이션 시작 시 init 메서드를 실행해 테스트용 데이터를 미리 저장하는 역할을 함

### 2. 객체 관리와 어노테이션
```java
@Repository  
public class TodoRepository {  
	...
}
```
* `@Repository `
	* 해당 클래스가 데이터 저장소(Repository) 역할을 하는 컴포넌트임을 스프링에게 알린다.
	* 스프링은 해당 클래스의 인스턴스를 단 하나만 생성해서 관리한다.(싱글톤 패턴)

```java
@Controller
public class TodoController {
	...
}
```
* `@Controller`
	* 해당 클래스가 웹 요청을 처리하는 컨트롤러(Controller)임을 알린다.

> 스프링은 `@Component`, `@Controller`, `@Service`, `@Repository` 같은 어노테이션이 붙은 클래스를 감지해 자동으로 객체(Bean)로 만들어서 컨테이너에 등록한다.


### 3. 의존성 주입(DI)
#### `TodoController.java`
```java
@Controller  
@RequestMapping("/todos")  
public class TodoController {  
  
    private final TodoRepository todoRepository;  

	// 생성자 주입
    public TodoController(TodoRepository todoRepository) {  
        this.todoRepository = todoRepository;  
    }  
  
    @GetMapping  
    public String todos(Model model) {  
        // 생성 시 사용한 TodoRepository와 다른 인스턴스임  
//        TodoRepository todoRepository = new TodoRepository();  

		// new 없이 사용함
        List<TodoDto> todos = todoRepository.findAll();  
        model.addAttribute("todos", todos);  
  
        return "todos";  
    }
```
1. `private final TodoRepository todoRepository;`
	* `TodoController`가  `TodoRepository`에 의존한다.
2. `public TodoController(...)`
	* 생성자를 통해 스프링 컨테이너가 미리 만들어 둔 `TodoRepository` 객체를 주입해준다.(매개변수로)
3. `todoRepository.findAll()`
	* `new TodoRepository()`를 하지 않고 주입받은 객체를 사용만 함

> DI를 통해 애플리케이션 전체에서 동일한 `TodoRepository` 인스턴스를 공유해 데이터 일관성을 유지할 수 있다.


### 4. MVC 패턴과 웹 요청 처리
#### `@RequestMapping("/todos")`
* `/todos` 로 시작하는 모든 HTTP 요청을 해당 컨트롤러가 처리하도록 지정한다.

#### `@GetMapping`, `@PostMapping`
* HTTP GET, POST 요청을 처리하는 메서드를 지정한다.
* `http://localhost:8080/todos` 주소로 접속하면 `@GetMapping`이 붙은 `todos()` 메서드가 실행된다.

#### `Model`
* 컨트롤러에서 처리한 데이터를 뷰(HTML 파일)로 전달하는 역할을 한다. 
* `model.addAttribute("todos", todos);`는 todos라는 이름으로 `List<TodoDto>` 데이터를 `todos.html` 파일에 전달함