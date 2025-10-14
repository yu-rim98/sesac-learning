# React에서 자주 사용하는 기본 Hook인 `useState`와 `useEffect`에 대한 정리

## 1. `useState`

> `useState`는 함수형 컴포넌트에서 **상태(state)** 를 관리할 수 있도록 도와주는 Hook이다.  
> 클래스 컴포넌트의 `this.state`, `this.setState()`를 대체한다.

### 문법

```javascript
const [state, setState] = useState(initialValue);
```

- `state` : 현재 상태 값
- `setState` : 상태를 변경하는 함수
- `initialValue` : 상태의 초기값

### 예제 : 카운터

```javascript
import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  const increment = () => setCount(count + 1);

  return (
    <div>
      <p> 카운트 : {count} </p>
      <buttoun onClick={increment}>증가</buttoun>
    </div>
  );
}
```

- 버튼이 클릭되면 count 값을 1 증가한다.

---

## 2. `useEffect`

> React 컴포넌트가 렌더링될 때마다 특정 작업(부수 효과, Side Effect)을 수행하도록 하는 Hook이다.  
> 클래스 컴포넌트의 `componentDidMount`, `componentDidUpdate`, `componentWillUnmount` 를 대체한다.

### 문법

```javascript
useEffect(() => {
	// 실행할 코드 (effect)
	return () => {
		// 정리(clean-up) 함수 (선택 사항)
	};
}, [의존성 배열]);
```

### 의존성 배열

- `[]` : 처음 마운트될 때만 실행한다. (1번 실행)
- `[state]` : 특정 상태가 바뀔 때만 실행한다.
- 생략 : 매 렌더링마다 실행한다.

### 예제 : API 호출

```javascript
import { useEffect, useState } from "react";
import axios from "axios";

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios
      .get("https://dummyjson.com/users")
      .then((response) => setUsers(response.data));
  }, []); // 처음 한번만 실행
}
```

- UserList 컴포넌트가 처음 마운트될 때 한번만 실행한다.
