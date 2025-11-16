## 1. 람다식(Lambda)란
* **익명 함수를 간결하게 표현하는 문법**이다.
#### 기존
```java
Comparator<Integer> comp = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(a, b);
    }
};
```
* 익명 클래스를 만들어서 객체화 해야 함

#### 람다식 사용
```java
Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);
```
* 클래스 + 생성자 + 메서드 오버라이딩이 자동으로 만들어진다.
* 즉, 무엇을 하는 함수인지만 남김

## 2. 람다는 *함수를 값처럼 전달*하기  위한 문법
* 자바는 원래 **메서드를 값처럼 전달할 수 없는 언어**였지만 람다 이후에 메서드를 변수에 담아 전달할 수 있게 되었다. (함수형 프로그래밍이 가능)
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
System.out.println(add.apply(10, 20));
```
>즉, 람다는 **메서드를 변수처럼 쓰는 것**

## 3. 람다는 *함수형 인터페이스*에서만 사용 가능
#### 메서드가 딱 1개인 인터페이스에서만 사용 가능함
```java
@FunctionalInterface
interface Calculator {
	int calculate(int a, int b)
}

Calculator cal = (a, b) -> a + b;
```
>메서드가 2개 이상이면 람다를 사용할 수 없다.   
>`@FunctionalInterface` 어노테이션을 붙이면 컴파일러가 체크해줌

## 4. 표준 함수형 인터페이스
|이름|매개변수|반환|설명|
|---|---|---|---|
|**Supplier**|X|T|값 공급|
|**Consumer**|T|void|값 소비 (출력 등)|
|**Function<T, R>**|T|R|입력 → 출력|
|**BiFunction<T, U, R>**|T, U|R|두 입력 → 출력|

## 5. 메서드 참조(::)
### 1. static 메서드 참조
```java
Function<String, Integer> parser = Integer::parseInt;
```

### 2. 인스턴스 메서드 참조
```java
String prefix = "hihi";
Function<String, String> greeter = prefix::concat;

System.out.println(greeter.apply("kim"));
```
