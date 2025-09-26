const user = {
  name: "홍길동",
};

// address는 user 객체의 속성에 포함되지 않음
console.log(user.address); // undefined

// 정의되지 않은 undefined에 접근하려하니 에러 발생함
// TypeError: Cannot read properties of undefined (reading 'city')
// console.log(user.address.city);

// 옵셔널 체이닝(Optional Chaining) 사용
console.log(user?.address?.city);
