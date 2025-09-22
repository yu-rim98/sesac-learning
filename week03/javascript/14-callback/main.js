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

const numbers = [1, 2, 3, 4, 5];

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
  if (element % 2 !== 0) {
    console.log(element);
  }
});

console.log("=======");

const numbers2 = [1, 2, 3, 4, 5];

// 각 원소에 + 1을 한 결과를 출력
console.log("각 원소에 +1 결과 출력");
numbers2.forEach((element) => {
  // 배열 원소에 반복적으로 수행할 로직 작성
  console.log(element + 1);
});

// 각 원소 중 짝수만 출력
console.log("각 원소 중 짝수만 출력");
numbers2.forEach((element) => {
  if (element % 2 === 0) {
    console.log(element);
  }
});

console.log("=======");

const newArr = [];

numbers2.forEach((element) => {
  newArr.push(element + 1);
});

console.log(newArr);

console.log("=======");

// map() 활용 : 콜백 함수의 반환값을 모아 새로운 배열을 생성해준다.
const newArrMap = numbers2.map((element) => {
  return element + 1;
});

console.log(newArrMap);

console.log("=======");

// map()을 활용해 * 2를 한 반환 값을 모아 새 배열 생성
console.log("map()을 활용해 * 2를 한 반환 값을 모아 새 배열 생성");

const newNumsArr = numbers2.map((element) => {
  return element * 2;
});

console.log(newNumsArr);
