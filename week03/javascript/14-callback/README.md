# JavaScript 콜백 함수(Callback Function)

> 콜백 함수는 다른 함수의 **인자(argument)** 로 전달되어 **특정 시점(나중에)에 호출(Call Back)** 되도록 약속된 함수로, 자바스크립트 비동기 처리의 가장 기본적인 패턴이다.

### 비유 : 카페에서 음료를 주문하고 진동벨을 받는 것과 같다.

> - 음료 주문(함수 호출) : **특정 작업을 요청**한다.
> - 진동벨 (콜백 함수) : 음료가 준비되면(**요청한 작업이 끝나면**) 울린다.(**함수를 실행한다.**)라는 약속이다.

## 콜백 함수의 3가지 형태

### 1. 기명 함수 전달

> 미리 정의된 함수를 전달하는 방식으로, 로직을 재사용하기 좋다.
>
> ```javascript
> function mainFunction(callback) {
>   console.log("main 함수 작업 시작.");
>
>   // 1초 뒤 callback 함수 실행
>   setTimeout(() => {
>     callback();
>   }, 1000);
> }
>
> function myCallback() {
>   console.log("작업 완료");
> }
>
> mainFunction(myCallback);
> ```

### 2. 익명 함수(Anonymous Function) 전달

> 일회성으로 사용할 함수를 즉석에서 정의하여 전달한다.
>
> ```javascript
> function mainFunction(callback) {
>   console.log("main 함수 작업 시작.");
>
>   // 1초 뒤 callback 함수 실행
>   setTimeout(() => {
>     callback();
>   }, 1000);
> }
>
> mainFunction(function () {
>   console.log("작업 완료");
> });
> ```

### 3. 화살표 함수(Arrow Function) 전달

> 현대 자바스크립트에서 가장 보편적으로 사용되는 간결한 방식이다.
>
> ```javascript
> function mainFunction(callback) {
>   console.log("main 함수 작업 시작.");
>
>   // 1초 뒤 callback 함수 실행
>   setTimeout(() => {
>     callback();
>   }, 1000);
> }
>
> mainFunction(() => {
>   console.log("작업 완료");
> });
> ```

## 콜백 함수의 주요 사용

### 1. 비동기 처리

> 시간이 걸리는 작업(서버 통신, 파일 읽기 등)이 끝난 후에 특정 코드를 실행하고 싶을 때 사용된다.
>
> ```javascript
> setTimeout(() => {
>   console.log("2초 지남");
> }, 2000);
> ```

### 2. 이벤트 핸들링

> 사용자의 행동(클릭, 키보드 입력 등)에 따라 특정 코드를 실행할 때 사용된다.
>
> ```javascript
> const myButton = document.getElementById("myButton");
>
> // 사용자가 버튼을 클릭하면 콜백 함수가 실행된다.
> myButton.addEventListener("click", () => {
>   alert("버튼 클릭됨");
> });
> ```

### 3. 배열 고차 함수

> `forEach`, `map`, `filter` 처럼 배열의 각 요소에 대해 실행할 커스텀 로직을 전달할 때 사용된다.
>
> ```javascript
> const numbers = [1, 2, 3, 4];
>
> // 각 요소에 대해 실행할 로직을 콜백으로 전달한다.
> numbers.forEach((number) => {
>   console.log(number);
> });
> ```
