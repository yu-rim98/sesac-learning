// 자바스크립트 비동기 처리 함수는
// setTimeout, setInterval, fetch 등이 있음

// setTimeout(콜백, 밀리초)
// 밀리초 뒤에 콜백 함수를 실행하는 비동기 처리 함수

console.log("setTimeout 전 코드");
setTimeout(() => {
  console.log("5000ms 후 실행");
}, 5000);

setTimeout(() => {
  console.log("1000ms 후 실행");
}, 1000);

setTimeout(() => {
  console.log("2000ms 후 실행");
}, 2000);

console.log("setTimeout 후 코드"); // setTimeout을 기다리지 않고 바로 실행됨 - 비동기 처리

// 자바스크립트 콜 스택에 올라온 setTimeout() 등의 비동기 함수를 WebAPIs로 전달한다.
// WebAPIs의 setTimeout() 함수가 해당 함수를 전달 받고, 매개변수인 밀리초를 카운팅한다.
// 카운팅이 다 되면 콜백 함수를 콜백 큐로 전달한다. -> 쌓임
// 이벤트 루프는 콜 스택이 비어 있을 때 콜백 큐의 첫번째 작업을 콜 스택에 전달한다. (콜 스택에 다른 작업이 있으면 큐에 있는 콜백 함수는 계속 대기해야 한다.)
