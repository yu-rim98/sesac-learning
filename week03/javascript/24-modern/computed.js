let key = "name";

// 객체 속성의 key는 무조건 문자열임 즉, key -> "key"
const user = {
  key: "홍길동",
};
console.log(user);

// 속성명을 [] 로 감싸주면 변수의 값을 key로 사용할 수 있다. 즉, key -> "name"
const user2 = {
  [key]: "홍길동",
};
console.log(user2);
