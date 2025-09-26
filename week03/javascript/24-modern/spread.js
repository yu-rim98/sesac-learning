const obj1 = {
  name: "홍길동",
  age: 20,
  job: "개발자",
  location: "서울",
  country: "대한민국",
};

// 객체 복사
const obj2 = obj1; // 객체의 참조값을 복사함

console.log(obj1);
console.log(obj2);

obj2.location = "대구";
// obj1과 obj2는 같은 객체를 참조하고 있기 때문에 obj2의 속성을 수정하면 obj1도 같이 수정됨
console.log(obj1);
console.log(obj2);

// 스프레드 연산자를 활용한 복사
const obj3 = { ...obj1 }; // obj1 객체 내부의 값을 펼치고 {} 리터럴로 객체가 새로 생성된다.
console.log(obj1);
console.log(obj3);

obj3.name = "고길동";

console.log(obj1);
console.log(obj3);
