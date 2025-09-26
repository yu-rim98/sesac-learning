let name = "홍길동";
let age = 20;

const user = {
  name: name,
  age: age,
};

console.log(user);

// 단축 속성
// 변수명과 객체의 속성명이 같으면 {key:value} 대신 {변수명}으로 축약
// 변수명과 key가 동일할 때
const user2 = {
  name,
  age,
};

console.log(user2);
