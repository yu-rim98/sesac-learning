## 1. 클래스와 객체(Class & Object)
* 클래스는 **객체를 만들기 위한 설계도**이다.
    * `Person`, `Rectangle`, `User`, `Calculator` 등이 클래스에 해당
* 객체는 **설계도를 바탕을 ㅗ메모리에 실체화된 것**이다.
    * `Main.java`에서 `new` 키워드를 사용해 객체를 생성하는 부분
```java
Calculator calculator = new Calculator();
Person p1 = new Person();
User user = new User("홍길동", 10);
```

## 2. 캡슐화(Encapsulation)
* 캡슐화는 데이터(필드)와 기능(메서드)을 하나로 묶고 외부의 직접적인 접근을 제한하여 데이터의 무결성을 보장하는 중요한 개념이다.
    * `private` 접근 제어자
        * `pravate`으로 선언된 변수는 외부 클래스에서 직접 수정할 수 없다.
    * `Getter/Setter` 메서드
        * 외부에서 `private` 필드에 안전하게 접근할 수 있도록 public으로 열어둔 통로이다.
        * `Setter`를 사용하면 잘못된 값이 필드에 저장되는 것을 막을 수 있다.
```java
public void setAge(int age) {
	if (age < 0 || age > 100) {
		throw new IllegalArgumentException("올바른 나이를 입력하세요.");
	}
	this.age = age;
}
```


## 3. 생성자(Constructor)와 `this()`
* 생성자
    * 객체가 생성될 때 필드를 초기화하는 특별한 메서드
    * 생성자 오버로딩 - 여러 개의 생성자를 가질 수 있음
* `this()`
    * 생성자 내부에서 다른 생성자를 호출할 때 사용한다.
    * 코드 중복을 줄이고, 초기화 로직을 한 곳으로 모을 수 있어 유지보수에 유리하다.
```java
public Person() {
	this("이름없음", 0, "주소 없음");
}

public Person(String name, int age) {
	this(name, age, "주소 없음");
}

public Person(String name, int age, String address) {
	this.name = name;
	this.age = age;
	this.address = address;
}
```


## 4. 메서드(Method)
* 메서드 오버로딩(Overloading)
    * 같은 이름의 메서드라도 매개변수의 개수나 타입이 다르면 여러 개를 정의할 수 있다.
* 인스턴스 메서드
    * 객체를 생성해야만 호출할 수 있다.
    * 인스턴스 필드 접근 가능
* 정적(static) 메서드
    * 객체 생성 없이 `클래스이름.메서드이름()` 형태로 호출할 수 있다.
        * `MethodType.staticMethod()`
    * 정적 필드에만 접근 가능

## 5. 참조에 의한 호출
* 메서드에 객체를 전달하면 그 객체의 **주소 값(참조)** 이 전달된다.
    * `changeValue(data)`가 호출될 때 data 객체의 주소가 매개변수로 복사된다.
    * 즉, `changeValue` 메서드 안에서 `data.value`를 수정하면 main 메서드에 있는 원본 data 객체의 value 값이 변경된다.