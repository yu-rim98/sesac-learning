// 배열 고차 메서드
// 배열 원소에 콜백 함수를 순차적으로 적용하는 메서드를 의미한다.

// 입렵값에 * 2 반환하는 함수
function multiTwo(value) {
  return value * 2;
}

function higherOrderFunction(array, callbackFunction) {
  for (let element of array) {
    const result = callbackFunction(element);
    console.log(result);
  }
}

numbers = [1, 2, 3, 4, 5];

// 콜백 함수를 인자로 전달
higherOrderFunction(numbers, multiTwo);

console.log("=======");

// 화살표 함수 전달 (콜백 함수)
higherOrderFunction(numbers, (value) => {
  return value + 1;
});

console.log("=======");

higherOrderFunction(numbers, (value) => {
  return value * value;
});

console.log("forEach 출력");
// forEach() 예시
numbers.forEach((element) => {
  console.log(element + 1);
});
