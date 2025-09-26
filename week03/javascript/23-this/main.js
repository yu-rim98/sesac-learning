// this 키워드

// 일반 함수에서 this는 '호출 시점'에 결정되며,
// 전역 컨텍스트에서 호출될 경우 this는 전역 객체를 참조한다.
// (브라우저: window / Node.js: global)
function func() {
  console.log("함수");
  console.log(this);
}

// 전역에서 호출하니까 전역 객체 가리킴
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

const user = {
  name: "고길동",
  age: 20,
  greet: function () {
    console.log(`제 이름은 ${this.name}이고 나이는 ${this.age} 입니다.`);
  },
};

user.greet();

// 화살표 함수로 표현한 메서드는 함수 선언식(function 키워드를 사용한 함수)과 작동 방식이 다르다.
const user2 = {
  name: "홍길동",
  age: 30,
  greet: () => {
    console.log(this);
  },
};

// greet는 화살표 함수이기 때문에 user2 객체의 this를 가리키지 않는다.
// 화살표 함수는 선언되었을 때 상위 스코프 this를 물려받는다,
// 즉, 해당 화살표 함수는 전역 스코프에서 정의된 것과 같다.
// 1. this -> 전역 객체(window or global)
// 2. 호출 주체는 user2이지만 화살표 함수는 전역 객체를 가리키고 있음
user2.greet();
console.log(this);

// 객체 메서드 내에서의 화살표 함수
const user3 = {
  name: "홍길동",
  age: 30,
  greet: function () {
    const arrowFunc = () => {
      console.log(this);
    };

    arrowFunc();
  },
};

// greet는 일반 함수이고 호출 주체는 user3 객체이다.
// 따라서 greet 안의 this는 user3 객체를 가리킨다.
// arrowFunc는 greet 내부에서 선언된 화살표 함수이며 해당 this는 greet this를 물려받는다.

// 1. this -> user3
// 2. 화살표 함수이지만 this는 바깥에서 받음 (greet)
// 3. user3.gree() 호출 -> greet 내부의 this는 user3을 가리킴 -> 화살표 함수에게 물려줌
user3.greet();
