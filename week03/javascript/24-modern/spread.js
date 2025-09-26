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

console.log("얕은 복사 vs 깊은 복사");
const user = {
  name: "홍홍홍",
  age: 20,
  addr: {
    location: "서울",
    country: "대한민국",
  },
};

console.log("얕은 복사");
const user2 = { ...user };
console.log(user);
console.log(user2);

user.addr.location = "대구";
console.log(user); // 대구
console.log(user2); // 대구

console.log("깊은 복사");
const user3 = structuredClone(user); // 중첩 객체의 참조 값 내부의 값까지 복사함
user3.addr.location = "서울";
console.log(user); // 대구
console.log(user3); // 서울
