# `const` 키워드의 동작 원리

> `const`로 선언된 변수는 **재할당이 불가능한 상수**를 선언한다.  
> 즉, 변수가 가리키는 참조(메모리 주소)를 바꿀 수 없다.

위와 같은 특징은 변수에 할당된 값의 종류가 **원시 타입(Primitive Type)** 이냐 **참조 타입(Object, Array)** 이냐에 따라 다르게 동작하는 것처럼 보인다.

## 1. 원시 타입 (String, Number, Boolean 등)

> 원시 타입의 값은 **불변(Immutable)**한다.  
> 값을 변경하려면 새로운 값을 만들어 변수에 다시 할당해야 하는데 `const`는 재할당을 금지하기 때문에 `const`로 선언된 원시 타입 변수는 값을 절대 변경할 수 없다.

```javascript
const name = "홍길동"; // 선언과 동시에 값 할당이 필수

// 새로운 값으로 재할당 시도 시 에러 발생
name = "김철수"; // TypeError: Assignment to constant variable.
```

## 2. 참조 타입 (Object, Array)

> 참조 타입의 값은 객체나 배열 자체가 변수에 저장되는 것이 아니라 **데이터가 저장된 메모리 주소(참조)** 가 저장된다.  
> `const`는 **해당 메모리 주소를 바꾸는 재할당만 금지** 하며 **해당 주소가 가리키는 객체 내부의 속성을 변경**하는 것은 가능하다.

```javascript
const user = {
  name: "홍길동",
  age: 20,
};

user.name = "김철수"; // 객체 내부의 속성을 변경하는 것은 가능하다. user가 가리키는 메모리 주소는 그대로이기 때문

const user2 = { name: "이영희" };

// user가 가리키는 메모리 주소 자체를 바꾸려 하기 때문에 에러 발생
user = user2; // TypeError: Assignment to constant variable.
```
