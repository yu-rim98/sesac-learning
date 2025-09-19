// 객체
// 0개 이상의 속성을 저장하는 자료형
// 속성 = key(이름) + value(값)
// {} 중괄호로 생성

// 변수 emptyObject를 선언하고 빈 객체를 할당
let emptyObject = {};

// key는 name
// value는 "홍길동"인
// 속성 -> key: value

// 변수 person1 할당
let person1 = { name: "홍길동" };

// 객체 생성 기본구조
let object = {
  key1: "value1",
  key2: "value2",
};

// 객체 속성 접근
// 대괄호 [] 사용
// 객체데이터["key"]

// 마침표 . 사용
// 객체데이터.key

// 변수 person2를 선언하고
// 객체 데이터
// name : 홍길동, score : 99, pass : true 할당하기
let person2 = {
  name: "홍길동",
  score: 99,
  pass: true,
};

console.log(person2["name"]);
console.log(person2.score);

// 객체 속성 수정
person2.name = "홍철수";

console.log(person2.name);

// 객체 속성 추가
// 1. 추가할 속성(key) 접근
// 2. value 데이터 할당
person2.address = "한국";
console.log(person2.address);

// 객체 속성 제거
delete person2.address;
console.log(person2);

// 객체 함수
// 모든 key를 배열로 반환
let keyArray = Object.keys(person2);
console.log(keyArray);

// 모든 value를 배열로 반환
let valueArray = Object.values(person2);
console.log(valueArray);

// 모든 key, value를 배열로 반환
let allArray = Object.entries(person2);
console.log(allArray);
