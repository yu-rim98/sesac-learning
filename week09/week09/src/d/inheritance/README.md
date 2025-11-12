## 상속의 기본 개념
* 상속은 기존 클래스(부모 클래스)의 필드와 메서드를 새로운 클래스(자식 클래스)가 **물려받아 재사용**하는 것을 말한다.
```java
class Animal {
	String name;
	void eat() {
        System.out.println("먹는 중");
	}
}

class Dog extends Animal {
	void bark() {
		System.out.println("멍멍");
	}
}
```
* `Dog`는 `Animal`의 `name`, `eat()`을 그대로 사용 가능하다.
* 즉, `Dog`는 `Animal`의 **확장된 형태**

---
## 상속의 장점

| 장점        | 설명                                        |
| --------- | ----------------------------------------- |
| 코드 재사용    | 공통된 속성과 기능을 부모 클래스에 정의하여 재사용 할 수 있다.      |
| 유지보수 용이   | 중복 코드가 감소하고, 수정 시 한 곳만 변경하면 된다.           |
| 계층 구조 설계  | "is-a 관계"를 표현할 수 있다. (예: Dog is a Animal) |
| 다형성 기반 제공 | 부모 타입으로 자식 객체를 다룰 수 있다.                   |

---
## 상속 문법
```java
class 자식클래스 extends 부모클래스 {
	// 부모의 속성과 메서드 모두 상속
	// 필요 시 메서드 오버라이딩 가능
}
```
* `extends` 키워드를 사용한다.
* 자바는 **단일 상속만 지원한다.**
* 모든 클래스의 최상위 부모는 `Object`이다.

---
## 생성자와 상속
* 생성자는 상속되지 않는다.
* **자식 생성자**는 **부모 생성자를 반드시 먼저 호출해야 한다.**
* 이때 `super(...)`를 사용 (부모 생성자 호출)
```java
class Animal {
	String name;
	Animal(String name) {
		this.name = name;
	}
}

class Dog extends Animal {
	Dog(String name) {
		super(name); // 부모 생성자 호출
	}
}
```
* 부모가 기본 생성자만 있으면 `super()` 가 자동으로 호출
* 부모가 매개변수 생성자만 있으면 `super(인자...)`를 명시

---
## 메서드 오버라이딩(Overriding)
* 상속받은 메서드를 **자식 클래스에서 재정의**하는 것
* 부모의 기능을 그대로 쓰지 않고, 상황에 맞게 수정할 때 사용한다.
```java
class Animal{
	void sound() {
		System.out.println("동물이 소리를 낸다.");
	}
}

class Dog extends Animal {

	@Override
	void sound() {
		System.out.println("멍멍");
	}
}
```
* 조건
    * 메서드 이름, 매개변수, 리턴 타입이 동일해야 한다.
    * 접근 제어자는 부모보다 좁으면 안된다.
    * `@Override` 어노테이션을 붙여주는 것이 좋다.

---
## super 키워드

| 구분                        | 설명            |
| ------------------------- | ------------- |
| `super()`                 | 부모 생성자 호출     |
| `super.변수`, `super.메서드()` | 부모 클래스의 멤버 접근 |
```java
class Dog extends Animal {
	String name;

	Dog(String name) {
		super(name); // 부모의 name 초기화
	}

	void printNames() {
		System.out.println(super.name); // 부모의 name 접근
	}
	
}
```

---
## 업캐스팅과 다형성(Polymorphism)
* 업캐스팅(Upcasting)
    * 부모 타입으로 자식 객체를 참조하는 것을 의미한다.
    * `Animal a = new Dog();`
* 다형성의 핵심
    * 부모 타입으로 자식을 참조하더라도 **오버라이딩된 자식 메서드가 실행된다.**
```java
Animal a = new Dog();
a.sound(); // "멍멍" 출력됨 (자식 메서드 실행)
```


> 상속은 **부모의 자산을 자식이 물려받는 것**이다.   
> 생성자는 상속되지 않지만, 호출 순서는 부모 -> 자식이다.   
> 오버라이딩으로 자식의 행동을 새로 정의하고, 다형성으로 부모 타입 하나로 여러 자식을 다룰 수 있다.

