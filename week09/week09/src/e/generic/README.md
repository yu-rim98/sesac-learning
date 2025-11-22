## 제네릭이란?
> 제네릭(Generic)은 클래스나 메서드 내부에서 사용하는 **데이터 타입을 일반화**하여 사용할 때 구체적인 타입을 지정할 수 있게 하는 문법이다.

### 목적
* 여러 타입을 하나의 클래스나 메서드로 처리하기 위함
* 형변환(casting) 제거
* 컴파일 시점에 타입 안전성을 보장

---
## 제네릭 미사용 시 문제점
```java
class Box {
	private Object item;
	
	public void setItem(Object item) {
		this.item = item;
	}
}

Box box = new Box();
box.setItem("hello");
String str = (String) box.getItem(); // 형변환 필요

box.setItem(123);
int i = (int) box.getItem(); // 런타임 오류 위험
```
### 문제점
* 형변환을 매번 해줘야 한다.
* 잘못된 타입으로 변환할 경우 `ClassCastException` 발생 가능성이 있다. (런타임 에러)

---
## 제네릭 기본 문법
```java
class Box<T> {
	private T item;

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}
}

Box<String> box1 = new Box<>();
box1.setItem("hello");
String str = box1.getItem(); // 형변환 불필요
```
* **T는 타입 매개변수(Type Parameter)**
	* 클래스 정의 시에는 결정하지 않고 사용 시점에 결정한다.

---
## 제네릭 클래스 다중 타입 매개변수
```java
class Pair<K, V> {
	private K key;
	private V value;

	public Pair (K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() { 
		return key;
	}
	
    public V getValue() {
	    return value;
	}
}

Pair<String, Integer> pair = new Pair<>("age", 20);
System.out.println(pair.getKey() + " : " + pair.getValue());
```
* `K`, `V`처럼 여러 타입 매개변수를 사용할 수 있다.
	* 대표적으로 `Map<K, V>`이 있음

---
## 제네릭 상속
```java
class Parent<T> {
	private T value;

	public Parent(T v) {
		value = v;
	}
}

class Child<T> extends Parent<T> {

	public Child(T value) {
		super(value);
	}
}

// 제네릭 타입 고정
class StringChild extends Parent<String> {
	public StringChild(String value) {
		super(value);
	}
}

class ExtendsChild<T, U> extends Parent<T> {
	private U value2;

	public ExtendsChild(T v1, U v2) {
		super(v1);
		this.value2 = v2;
	}
}
```
* `class Child<T> extends Parent<T>`
	* 타입 매개변수를 그대로 상속 받음
* `class StringChild extends Parent<String>`
	* 타입을 특정 타입으로 고정함
* `class ExtendsChild<T, U> extends Parent<T>`
	* 제네릭 매개변수를 추가 확장함

---
## 제네릭 메서드
```java
public class GenericMethod {

	public static <T> void printArray(T[] array) {
		for (T item : array) {
			System.out.println(item);
		}
	}

	public static <T> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		Interger[] nums = {1, 2, 3};
		String[] strs = {"A","B","C"};

        printArray(nums);
        printArray(strs);
	}
}
```
* `<T>`는 **메서드 단위에서만 타입 매개변수를 선언하는 문법**이다.
	* 클래스가 제네릭이 아니어도 사용 가능함

---
## 제네릭 제약(Type Bound)
> 제네릭 타입에 들어올 수 있는 타입을 제한하는 방법

### 상한 제한(Upper Bound)
> "해당 타입이거나 그 하위 타입만 가능"
```java
class Box<T extends Numbers> { // Number 또는 하위 클래스만 가능
	T value;
}
```
* 가능 : `Box<Integer>`, `Box<Double>`
* 불가능 : `Box<String>`

>`T extends Number` -> `T`는 반드시 `Number` 또는 그 하위 타입이어야 한다.

### 하한 제한(Lower Bound)
>"해당 타입이거나 그 상위 타입만 가능"
>주로 메서드 매개변수에서 사용된다.

```java
public static void addNumbers(List<? super Integer> list) {
	list.add(1); // 가능
	// list.add(3.14); // 불가능
}
```
* `? super Integer` -> `Integer` 또는 `Integer`의 상위 클래스(`Number`, `Object` 등)
* 즉, 해당 리스트에는 최소한 Integer를 넣을 수 있음

---
## 제네릭 장점

| 항목     | 제네릭 미사용        | 제네릭 사용            |
| ------ | -------------- | ----------------- |
| 타입 안전성 | 런타임 오류 발생 가능   | 컴파일 시점에 검증        |
| 형변환    | 매번 필요          | 불필요               |
| 재사용성   | 타입마다 별도 클래스 필요 | 하나의 코드로 다양한 타입 처리 |
| 가독성    | 낮음             | 높음                |
