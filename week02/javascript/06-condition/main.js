// if 조건문의 기본 구조

/*
  if (조건식) { 참 일 때 실행 }
*/

if (5 > 1) {
  console.log("5는 1보다 큼");
}

/* if ~ else if 조건문 기본 구조
  if (조건식) {
    참 일 때 실행
  } else if (조건식) { // if 조건식이 거짓일 때
    참 일 때 실행
  }
*/

if (5 > 10) {
  console.log("5는 10보다 큼");
} else if (5 > 7) {
  console.log("5는 7보다 큼");
} else if (5 > 5) {
  console.log("5는 5보다 큼");
} else if (5 > 3) {
  console.log("5는 3보다 큼");
}

/* if ~ else if ~ else 조건문 기본 구조
  if (조건식) {
    참 일 때 실행
  } else if (조건식) {
    참 일 때 실행
  } else { else는 조건식이 없음
    위 조건식이 모두 거짓일 떄
  }
*/

let number = 1; // 변수 number 선언 및 숫자 1 할당

// number가 0보다 크면 "양수"를 출력 / number 0보다 크지 않다면 "음수" 출력
if (number > 0) {
  console.log("양수");
} else {
  console.log("음수");
}

// number2를 선언하고 숫자 0 할당
// number2가 0보다 크면 "양수",
// number2 0보다 작으면 "음수",
// 둘 다 아니라면 "0" 출력
let number2 = 0;

if (number2 > 0) {
  console.log("양수");
} else if (number2 < 0) {
  console.log("음수");
} else {
  console.log("0");
}

// 중첩 조건문
// 조건문 내부에 조건문을 중첩하는 조건문

// 변수 score를 선언하고, 숫자 75를 할당한다
// 만약 변수 socre가 90 이상이라면
// 그런데 만약 변수 score가 90 미만 그리고(&&), 80 이상이라면
// 그런데 만약 변수 score가 80 미만 그리고(&&), 70 이상이라면
// 그런데 만약 변수 score가 70 미만 그리고(&&), 60 이상이라면
// 그런데 모두 아니라면

console.log("중첩 조건문");

let score = 75;

if (score >= 90) {
  console.log("90 이상");
} else if (score < 90 && score >= 80) {
  console.log("90 미만 80 이상");
} else if (score < 80 && score >= 70) {
  console.log("80 미만 70 이상");
} else if (score < 70 && score >= 60) {
  console.log("70 미만 60 이상");
} else {
  console.log("모두 아님");
}

if (score >= 90) {
  console.log("90 이상");
} else if (score >= 80) {
  console.log("90 미만 80 이상");
} else if (score >= 70) {
  console.log("80 미만 70 이상");
} else if (score >= 60) {
  console.log("70 미만 60 이상");
} else {
  console.log("모두 아님");
}

// 삼항 연산자 표현식
// 표현식 : 데이터를 생성하는 코드
// 조건식 결과는 무조건 참 또는 거짓
// 조건식 ? 조건식 결과가 참일 때 데이터 : 조건식 결과가 거짓일 때 데이터;

let msg = 2 > 1 ? "2는 1보다 크다" : "2는 1보다 크지 않다";
console.log(msg);

// 예시
let isLoggined = true;
const user = isLoggined ? "회원 사용자" : "비회원 사용자";
console.log(user);
