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

---
## 변수 호이스팅 (Variable Hoisting)
* 위 내용과 같이 변수 선언(`var`, `let`, `const`) 또한 호이스팅된다.
* 즉, 코드 실행 전에 변수 선언이 코드의 최상단으로 끌어올려지는 현상을 말한다.

### 1. `var`의 호이스팅
* 변수 선언이 호이스팅되며, 초기값은 자동으로 `undefined`로 설정된다.
```javascript
  console.log(a); // undefined

  var a = 10;
  console.log(a); // 10
```

### 2. `let`과 `const`의 호이스팅
* 선언 자체는 호이스팅된다.
* 하지만 초기화는 되지 않고 **일시적 사각지대(TDZ: Temporal Dead Zone)** 에 놓인다.
* 따라서 선언 전에 접근하면 에러가 발생한다.
```javascript
  console.log(b); //ReferenceError: Cannot access 'b' before initialization
  console.log(c); // ReferenceError: Cannot access 'c' before initialization

  let b = 20;
  const c = 30;
```

> 즉, `var` 키워드로 변수를 선언한다면 호이스팅 관련하여 예상하지 못한 에러를 마주칠 수 있으므로 `let`, `const` 키워드를 사용하는 것이 권장된다.
