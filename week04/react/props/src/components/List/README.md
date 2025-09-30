# 리스트 렌더링 (배열 렌더링)

> 리액트에서 배열 데이터를 사용해 동적으로 목록을 만들 수 있다.

## 핵심 원리

> JavaScript의 내장 함수인 `.map()`을 사용해 배열의 모든 항목을 한번씩 순회하면서 각 항목을 JSX 엘리먼트(예 : `<li>`, `<User />`)로 변환한다.  
> 이처럼 변환된 엘리먼트들의 배열이 화면에 렌더링된다.

- `key` Props의 중요성 : `.map()`을 사용해 목록을 만들 때 각 엘리먼트에 반드시 `key`라는 특별한 prop을 전달해야 한다.
  - 역할 : `key`는 리액트가 어떤 항목이 변경, 추가 또는 삭제되었는지 식별하는 것을 돕는다.
  - 규칙 : `key`는 같은 목록 내 형제 엘리먼트들 사이에서 고유해야 한다. (보통 데이터에 포함된 id를 사용함)

코드 예시

```jsx
// Container.jsx - 부모 컴포넌트
const userArray = [
  { id: 1, name: "우영" },
  { id: 2, name: "길동" },
  { id: 3, name: "철수" },
];

// userArray를 map으로 순회하며 User 컴포넌트를 렌더링
// 각 User 컴포넌트에 고유한 'key'로 user.id를 전달합니다.
{
  userArray.map((user) => <User key={user.id} user={user} />);
}

// User.jsx - 자식 컴포넌트
const User = ({ user }) => {
  return (
    <li>
      {user.id} - {user.name}
    </li>
  );
};
```
