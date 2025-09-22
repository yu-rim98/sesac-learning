// 일급 객체
// 1. 변수에 할당할 수 있다.

// 함수 선언식
const le = function 함수명() {};

// 함수 표현식
// 함수 이름이 없고, 변수에 할당할 수 있다.
const functionExpression = function () {};

// 화살표 함수
// 함수 이름이 없고, 변수에 할당할 수 있다.
const functionArray = () => {};

// 일급 객체
// 2. 함수의 반환 값으로 사용 가능하다.
function calculator(operator) {
  if (operator === "더하기") {
    return (n1, n2) => {
      return n1 + n2;
    };
  }

  if (operator === "빼기") {
    return (n1, n2) => {
      return n1 - n2;
    };
  }
}

const add = calculator("더하기");
const sub = calculator("빼기");
console.log(add(1, 2));
console.log(sub(2, 1));

// 일급 객체
// 3. 함수의 인자로 전달 가능하다.

// calculator2
// 매개변수로 받은 특정 연산 함수를 수행하고, 결과를 출력하는 함수
function calculator2(operatorFunction, n1, n2) {
  const result = operatorFunction(n1, n2);
  console.log(`연산 결과 : ${result}`);
}

calculator2(
  (a, b) => {
    return a + b;
  },
  2,
  1
);

function 파스타_만들기(면준비) {
  console.log("1. 물 끓이기");
  console.log("2. 소금 넣기");
  console.log("면 선택 : ");
  면준비();

  console.log("3. 소스 넣고 완성");
  console.log("=============");
}

파스타_만들기(() => {
  console.log("스파게티면 준비");
});

파스타_만들기(() => {
  console.log("푸실리면 준비");
});

파스타_만들기(() => {
  console.log("야채만 준비");
});
