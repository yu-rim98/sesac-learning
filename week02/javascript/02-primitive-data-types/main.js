// console.log("Hello");

// typeof : 데이터의 자료형을 확인
console.log(typeof "Hello World"); // string

// 원시 자료형 5개 (원래 7개)
// 1. 문자열 (string)
// 문자 (글자)의 나열 : 0개 이상의 문자를 나타내는 자료형

// 빈 문자열("")도 문자열이다.
console.log(typeof ""); // stirng

// 2. 숫자형 (Number)
// 모든 종류의 숫자 (정수, 0, 실수)
console.log(10);
console.log(0);
console.log(-1);
console.log(1.1);

// 10, 0, -1, 1.1 자료형 log
console.log(typeof 10);
console.log(typeof 0);
console.log(typeof -1);
console.log(typeof 1.1);

// 논리형, 불리언 (Boolean)
// 참 / 거짓을 표현하며 true / false 2개의 데이터만 존재한다.
console.log(true);
console.log(typeof true);

// 특별한 자료형

// undefined
// 변수에 값이 할당되지 않은 상태 / 비어있는 상태
// 개발자가 의도하지 않은 비어있음을 표현
console.log(typeof undefined);

// null
// 변수에 값이 할당되지 않은 상태 / 비어있는 상태 -> 값이 명시적으로 없음
// 개발자가 의도한 비어있음을 표현
console.log(typeof null);
