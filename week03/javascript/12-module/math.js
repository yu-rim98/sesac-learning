// 외부 파일(모듈)로 내보낼 코드
function add(n1, n2) {
  return n1 + n2;
}

// 빼기 (substract)
function substract(n1, n2) {
  return n1 - n2;
}

// 곱하기 (multiply)
function multiply(n1, n2) {
  return n1 * n2;
}

// 나누기 (devide)
function devide(n1, n2) {
  return n1 / n2;
}

// 상수도 가능
const PI = 3.14;

// 함수 add 내보내기
export { add, substract, multiply, devide, PI };
