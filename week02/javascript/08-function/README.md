# 호이스팅 (Hoisting)
- 변수나 함수 선언을 실행 전에 코드의 최상단으로 끌어올리는 자바스크립트의 동작 방식을 말한다.
- 단, **선언만** 호이스팅되고, **초기화(할당)** 는 호이스팅되지 않는다.

## 함수 선언식 vs 함수 표현식

### 1. 함수 선언식 (Function Declaration)
```javascript
  greet(); // 함수 선언 전에도 호출 가능

  function greet() {
    console.log("Hello!");
  }
```
* `function greet()` 자체가 통째로 호이스팅된다.
* 코드 어디서든 호출이 가능함 

### 2. 함수 표현식 (Function Expression)
```javascript
  sayHello(); // TypeError: sayHello is not a function

  const sayHello = function() {
      console.log("Hi!");
  }
```
* `sayHello`라는 **변수 선언만** 호이스팅된다. (`undefined`)
* 함수 자체는 할당되지 않았기 때문에 선언 이전에 호출하면 에러 발생한다.

  
> **함수 선언식**은 함수 전체가 호이스팅되므로, **선언 이전에도 호출할 수 있다**.   
> **함수 표현식**은 변수의 선언만 호이스팅되고, **함수 값(할당)**은 호이스팅되지 않기 때문에** 변수에 값이 할당되기 전까지는 해당 함수를 사용할 수 없다.**
