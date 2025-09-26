// 구조 분해 할당

const object = {
  name: "홍길동",
  name2: "홍길동",
  age: 20,
  age2: 20,
};

// 구조 분해 할당 활용 X
// 속성을 개별 변수에 할당해야 한다.
let name = object.name;
let age = object.age;

// 구조 분해 할당 O
let { name2, age2 } = object; // object 객체의 속성 값을 변수에 저장 (이때 속성명과 변수명이 일치해야 함)

console.log(name);
console.log(name2);

const object2 = {
  id: 1,
  title: "갤럭시 88",
  description: "삼성 스마트폰",
  price: 9900,
};

// object2에서 title과 price 값만 필요하다면
let { title, price } = object2;
console.log(title);
console.log(price);
