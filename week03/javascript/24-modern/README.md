# 객체 복사와 참조 : 얕은 복사와 깊은 복사

## 객체의 참조 복사

```javascript
const obj1 = {
  name: "홍길동",
  age: 20,
  job: "개발자",
  location: "서울",
  country: "대한민국",
};

const obj2 = obj1; // obj1의 참조값을 복사함
```

- 두 변수는 같은 객체를 가리킨다.
- 하나의 속성을 변경하면 모두에 반영된다.

```javascript
obj2.location = "대구";
console.log(obj1.location); // "대구"
```

- obj2를 통해 변경했지만 obj1도 함께 변경된다. (같은 객체를 가리키고 있기 때문)

## 스프레드 연산자 `{ ...obj }` - 얕은 복사

```javascript
const obj3 = { ...obj1 };
```

- `...` 연산자는 **객체의 속성을 펼쳐서 새로운 객체 리터럴(`{}`)에** 넣는다.

* 객체 1단계까지만 복사된다. 즉, 중첩된 객체나 배열은 여전히 참조값이 복사된다.

```javascript
const user = {
  name: "홍길동",
  addr: {
    location: "서울",
  },
};

const user2 = { ...user };
user2.addr.location = "대구";

console.log(user.addr.location); // "대구", 중첩 객체의 값은 여전히 동일한 참조값을 가지기 때문에 함께 변경됨
```

> 즉, **얕은 복사(shallow copy)** 는 객체의 1단계 속성만 복사하기 때문에 **중첩 객체나 배열은 참조값을 복사하기 때문에 복사본을 수정하면 원본도 함께 수정**된다.

## `structuredClone()` - 깊은 복사

```javascript
const user3 = structuredClone(user);
```

- 객체를 깊게 복사해 **완전히 새로운 객체를 생성**한다.
- 중첩된 객체나 배열도 모두 **새로운 참조로 복사**된다.
- 즉, 원본 객체와 완전히 독립적이게 된다.

```javascript
user3.addr.location = "서울";
console.log(user.addr.location); // "대구", 영향 없음
console.log(user3.addr.location); // "서울"
```

> 즉, **깊은 복사(deep copy)** 는 모든 중첩 구조까지 복사해 새로운 복사본을 만드는 것이기 때문에 원본의 값 변경은 복사본에 영향을 주지 않는다.

## 스프레드 연산자의 동작

```javascript
const obj3 = { ...obj }; // {} 리터럴이 새로운 객체를 생성하는 것
```

- `...obj1`는 **객체의 속성만 펼친다.**
- `{}` **리터럴은 새로운 객체를 생성**한다.
- 그래서 `obj3`은 obj1과 **다른 객체**이지만, 중첩 속성은 **같은 참조**를 가진다.

> 스프레드 연산자는 **기존 객체/배열을 펼치는 역할만 한다.**
> 실제로 새 객체나 배열을 만드는 것은 **리터럴(`{}` 또는 `[]`)이다.**
