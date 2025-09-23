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
