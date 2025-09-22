// 예외처리
// 프로그램 실행 중 발생하는 오류를 처리하는 기술
// 예외(오류) 발생 시, 프로그램이 종료되지만 예외 처리를 통해 프로그램 종료 대신 적절한 대처 가능

const constVar = "상수";

try {
  // try 코드 블럭
  // 오류 발생 가능성이 있는 코드를 작성
  constVar = "상수 재할당";
} catch (error) {
  // catch 코드 블럭
  // 오류 발생 시 실행할 코드를 작성
  // error 매개변수를 받음. error 매개변수는 오류의 정보를 가지고 있는 객체이다.
  console.log("상수 재할당 오류 발생");
  console.log(error.name); // TypeError
  console.log(error.message); // Assignment to constant variable.
} finally {
  // finally 코드 블럭
  // 오류 발생 여부와 상관없이 실행할 코드를 작성
  // 무조건 실행되는 코드
  console.log("오류 발생 후 finally 코드");
}

console.log("시스템 로직 ...");
