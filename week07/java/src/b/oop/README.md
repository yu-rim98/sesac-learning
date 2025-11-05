## 객체 지향 프로그래밍(OOP)
### 객체 지향 프로그래밍이란?
* Object-Oriented Programming (OOP)은 데이터를 중심으로 사고하고, 데이터와 그 데이터를 다루는 **기능(메서드)을 하나의 객체**로 묶어 관리하는 프로그래밍 방식
* 절차지향 프로그래밍이 **어떻게 처리할까**에 초점을 맞추면 객체지향은 **누가 처리할까**에 초점을 둔다.

### 핵심 개념

| 개념  | 설명                                        |
| --- | ----------------------------------------- |
| 캡슐화 | 데이터(필드)와 기능(메서드)을 하나의 객체로 묶어 외부로부터 보호하는 것 |
| 상속  | 기존 클래스를 확장하여 새로운 클래스를 만드는 것               |
| 다형성 | 같은 동작(메서드)이지만 객체마다 다르게 동작할 수 있는 성질        |
| 추상화 | 복잡한 내부 동작은 감추고 필요한 정보만 드러내는 것             |

### 클래스와 객체
* 클래스 : 객체를 생성하기 위한 설계도 또는 템플릿
* 객체 : 클래스로부터 실제로 만들어진 인스턴스
```java
public class Rectangle {
    public int width;
    public int height;

    public int area() {
        return this.width * this.height;
    }
}
```
```java
Rectangle r1 = new Rectangle(); // 객체 생성
r1.width = 10;
r1.height = 20;
System.out.println(r1.area()); // 객체가 스스로 면적 계산
```
* 클래스는 **데이터(필드)와 행동(메서드)을 함께 정의한 구조체**

### 생성자(Constructor)
* 객체를 초기화하는 특별한 메서드
* 클래스 이름과 동일하며 반환 타입이 없음
```java
public class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name; // this는 현재 객체 자신
        this.age = age;
    }
}
```
```java
Dog d = new Dog("초코", 3);
```

### 메서드(Method)
* 객체의 **동작(행위)** 을 정의
```java
void introduce() {
    System.out.println("Hello!");
}
```

### 클래스를 사용하지 않았을 때의 문제
```java
public class Intro {
    public static void main(String[] args) {
        int width = 100;
        int height = 200;

        int area = width * height;
        System.out.println(area);

        // 다른 사각형을 만들려면 코드 중복 발생
        int width2 = 10;
        int height2 = 20;
        int area2 = width2 * height2;
    }
}
```
#### 문제
* 코드 중복 발생
* 도형이 늘어날수록(원, 삼각형 등) `main()`에 계산 코드 계속 추가됨
* 데이터(width, height)와 기능(area 계산)이 분리되어 있음

### 메서드로 중복 제거(불완전)
```java
public class Intro {
    public static void main(String[] args) {
        int rec1 = calArea(100, 200);
        int rec2 = calArea(10, 20);
    }

    public static int calArea(int width, int height) {
        return width * height;
    }
}
```
#### 문제
* 새로운 도형이 생기면 `Main` 클래스에 계속 메서드를 추가해야 함
* `width`, `height`가 객체 내부에 저장되지 않고 **매번 외부에서 전달**되어야 함
    * 즉, **데이터와 기능이 분리**되어 있음

### 객체지향적으로 개선하기
```java
class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

public class Intro {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(100, 200);
        System.out.println(rec1.area());

        Rectangle rec2 = new Rectangle(10, 20);
        System.out.println(rec2.area());
    }
}
```


### 개선된 구조의 장점

| 항목     | 절차지향 방식              | 객체지향 방식               |
| ------ | -------------------- | --------------------- |
| 데이터 관리 | 데이터와 기능이 분리됨         | 데이터와 기능이 객체 안에 캡슐화됨   |
| 재사용성   | 새로운 도형이 생기면 코드 수정 필요 | 클래스만 정의하면 여러 객체 생성 가능 |
| 유지보수성  | 수정 시 여러 곳 변경 필요      | 객체 내부만 수정하면 됨         |
| 현실 표현력 | 계산 중심                | "사각형"이라는 개체 중심        |

> 즉, 객체지향은 **데이터와 그 데이터를 다루는 기능을 하나로 묶는 사고방식**이다.
> 현실 세계의 개념(사람, 사각형, 자동차 등)을 프로그램 안의 **객체**로 표현하여 코드의 재사용성과 확장성을 높이는 것이 OOP의 핵심이다.