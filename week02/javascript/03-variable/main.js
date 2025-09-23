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
// message5 = "Hello World"; // TypeError: Assignment to constant variable.

// 템플릿 리터럴
// 문자열 사이에 변수를 삽입해 문자열을 생성하는 방법
// 1. 문자열을 백틱(`)으로 표현
// 2. 변수 삽입 위치에 ${} 기호를 사용한다.
// ${변수명}
let name = "최유림";
let greet = `안녕하세요. ${name}입니다.`;
console.log(greet);

// var
// 초기 버전의 변수 선언 방식
// 변수 재선언, 변수에 값 재할당 가능

// const 정리
// const로 선언된 변수는 선언 시 값 할당이 필수이며, 할당된 값 자체를 변경할 수 없다.
const name2 = "이름";

// 저장된 안녕하세요 값을 변경하려면 에러
// name2 = "이름 변경"; // TypeError: Assignment to constant variable.
console.log(name2);

// 배열 or 객체 (참조형)
const obj = { name: "이름" };

obj.name = "이름 변경"; // obj의 참조값(메모리 주소)이 아니라 obj가 가리키는 객체 내부의 속성을 변경하므로 가능

const obj2 = { age: 20 };

obj = obj2; // obj의 참조값(메모리 주소)을 변경하는 것은 불가함

console.log(obj);
