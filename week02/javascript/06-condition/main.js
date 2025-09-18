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
