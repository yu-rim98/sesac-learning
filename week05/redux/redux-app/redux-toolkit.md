# Redux Toolkit — 스토어와 슬라이스 구조 정리

## 1. 스토어(Store)란?

> **앱 전체 상태(state)** 를 보관하는 중앙 저장소로 **하나의 앱에 보통 하나의 스토어만 존재**한다.

- `counfigureStore()`로 생성할 수 있다.

```javascript
export const store = configureStore({
  reducer: {
    counter: counterReducer,
    auth: authReducer,
  },
});
```

- 하나의 스토어 안에 여러 슬라이스를 **객체 형태로 병합**
- 즉, 스토어는 집, 슬라이스는 집의 방들

## 2. 슬라이스(Slice)란?

> 상태(state)와 로직(reducer/action)을 묶은 작은 모듈로, 각 슬라이스는 자신의 **초기 상태(initialState)와 리듀서(reducers)** 를 가지고 있다.   
> 예 : `counterSlice`, `authSlice`

```javascript
const counterSlice = createSlice({
  name: "counter",
  initialState: { count: 0 },
  reducers: {
    increment: (state) => {
      state.count += 1;
    },
    reset: (state) => {
      state.count = 0;
    },
  },
});
```

- `counterSlice.reducer` : 스토어에 등록할 리듀서 함수
- `counterSlice.actions` : 자동으로 만들어진 액션 생성자들

## 3. 슬라이스가 여러 개일 때 상태 구조

```javascript
store = {
  counter: { count: 5 },
  auth: { user: { name: "홍길동" }, isLoggedIn: true },
};
```

슬라이스

1. counter
   - 저장 위치 : `state.counter`
   - 역할 : 숫자 관련 상태
2. auth
   _ 저장 위치 : `state.auth`
   _ 역할 : 사용자 인증 관련 상태
   > 각 슬라이스는 서로 다른 방에 저장되고 하나의 스토어에 함께 존재한다.

## 4. 컴포넌트에서 접근하는 방법

> 모든 컴포넌트는 스토어의 상태를 **전역적으로 접근 가능**하다. (`Provider`로 연결되어 있으므로)

```javascript
import { useSelector, useDispatch } from "react-redux";
import { increment } from "./counterSlice";

function Counter() {
  const count = useSelector((state) => state.counter.count);
  const dispatch = useDispatch();

  return (
    <>
      <p>Count: {count}</p>
      <button onClick={() => dispatch(increment())}>+1</button>
    </>
  );
}
```

- `state` : 스토어의 전체 상태 객체를 의미
- `state.counter` : counter 슬라이스의 상태
- `state.counter.count` : 그 안의 특정 값

## 5. useSelector의 동작 원리

```javascript
useSelector((state) => state.auth.user);
```

- `useSelector`는 리액트 컴포넌트에서 스토어 상태를 꺼내 쓰는 훅
- 매개변수 `(state)`는 스토어 전체 상태 객체를 의미한다.
- 즉, 그 안에서 필요한 값만 골라서 반환하면 된다.
