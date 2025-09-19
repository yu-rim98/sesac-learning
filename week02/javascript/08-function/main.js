// 두 숫자를 매개변수로 받아서 더한 숫자를 반환하는 함수

// 매개변수가 3개인 함수
function add(number1, number2, number3) {
  // 함수 호출 시 실행될 코드 블럭
  // 숫자 3개를 매개변수로 받아 더한 값을 반환하는 함수
  return number1 + number2 + number3; // 반환
}

// 함수 호출
const result = add(10, 10, 10);

console.log(result);

// 호이스팅 : 끌어올리다

// 호이스팅 현상으로 인해 함수 선언 전에 함수를 호출해도 함수가 실행된다.
// 함수 선언을 위로 끌어올려 먼저 선언하기 때문
const result2 = getStr("유림");

function getStr(str) {
  return "Hello " + str;
}

// 함수 표현식(익명 함수) 정의
const sub = function (number1, number2) {
  return number1 - number2;
};

console.log(sub(20, 10));
