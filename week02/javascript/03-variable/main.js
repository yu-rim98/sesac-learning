// 변수에 데이터 할당

// 변수명 = 할당할 데이터
// "Hello World" 데이터를 저장한 공간의 이름이 message
// 변수 message에 "Hello World"를 할당
message = "Hello World";

console.log(message);
console.log(message);
console.log(message);

// 변수 선언
// 선언과 할당은 분리 가능
let message2;

// 선언의 방식 2개
// let : 데이터의 재할당 가능 - 변수
let message3 = "Hello variable";

// 변수 message3에 "Hello let variable" 재할당한다.
message3 = "Hello let variable";

// const : 데이터의 재할당 불가능 - 상수
const message5 = "Hello Const";
message5 = "Hello World"; // TypeError: Assignment to constant variable.
