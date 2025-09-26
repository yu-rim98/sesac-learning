// this 키워드

// 일반 함수에서 this는 전역 객체를 참조한다. (브라우저 환경 : window 객체 참조, Node 환경 : global 객체 참조)
function func() {
  console.log("함수");
  console.log(this);
}

func();
// 객체 : key - value 속성으로 구성됨
// 함수도 value가 될 수 있음 (객체 속성에 포함될 수 있음)
// 객체에 포함된 함수는 메서드라고 함
const obj = {
  name: "홍길동",
  age: 20,
  func: function () {
    console.log(this);
  },
};

// 함수를 실행한 객체를 가리킨다.
obj.func(); // obj를 가리킴
