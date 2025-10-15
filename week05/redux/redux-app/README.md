# Redux Toolkit 기본 개념 & 구조 정리

## 1. Redux Toolkit

> **리덕스(Redux)를 더 쉽게 쓰기 위한 공식 도구 모음**으로 **액션 타입, 액션 생성자, switch문, 불변성 관리** 등 복잡하고 반복되는 **코드를 자동화**해준다.

## 2. 기본 개념

1. `State(상태)`
   - 역할 : 앱이 기억(관리)해야 하는 값(상태)이다.
   - Redux Toolkit : `initialState`로 정의한다.
2. `Action(액션)`
   - 역할 : "무슨 일을 할 건지" 설명(정의)하는 객체이다.
   - Redux Toolkit : 자동 생성된다.
3. `Reducer(리듀서)`
   - 역할 : 액션에 따라 상태를 바꾸는 함수이다.
   - Redux Toolkit : `reducers` 안에서 함수로 작성한다.
4. `Store(스토어)`
   - 역할 : 상태를 한 곳에서 보관한다.
   - Redux Toolkit : `configureStore()`로 생성한다.
5. `Dispatch`
   - 역할 : 액션을 실행시키는 함수이다.
   - Redux Toolkit : `dispatch(slice.actions.xxx())` 형태로 사용한다.

## 3. Redux Toolkit의 핵심 함수 : `createSlice()`

```javascript
const counterSlice = createSlice({
  name: "counter", //슬라이스 이름
  initialState: { count: 0 }, //초기 상태 (count : 상태명, 0 : 상태 값)
  reducers: {
    // 상태를 바꾸는 함수들 (리듀서)
    increment(state) {
      state.count++; // Immer가 불변성을 자동으로 관리하므로 상태를 직접 수정 가능
    },
    incrementByAmount(state, action) {
      state.count += Number(action.payload);
    },
    reset(state) {
      state.count = 0;
    },
  },
});
```

- `createSlice()`가 자동으로 해주는 일
  1.  각 `reducers` 함수마다 **액션 타입**을 자동으로 생성
      - `counter/increment`, `counter/incrementByAmount` 등
      - 즉, reducers에 상태를 변경하는 함수를 정의해두면 그 함수를 기반으로 액션 타입을 생성해주는 것
  2.  액션 생성자(action creators) 함수를 자동으로 생성
      - 액션 생성자를 슬라이드의 actions에 자동으로 생성해줌
      - `counterSlice.actions.increment()`
  3.  리듀서 함수도 자동으로 하나로 합침
      - `counterSlice.reducer`

### slice에서 내보내기

- 액션 생성자 함수와 리듀서 함수를 내보낸다.

```javascript
export const { increment, incrementByAmount, reset } = counterSlice.actions;

export default counterSlice.reducer;
```

## 4. 스토어 설정

```javascript
import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./counterSlice";

export const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});
```

- 전역 상태를 보관할 스토어를 생성한다. (`configureStore`)
  - store 생성에 필요한 reducer를 전달함
    - counter가 state 이름
    - counterReducer가 슬라이스에 설정한 리듀서와 액션 정의

## 5. 실제 사용 흐름 (컴포넌트 예시)

```javascript
import { useSelector, useDispatch } from "react-redux";
import { increment, incrementByAmount, reset } from "./counterSlice";

const Counter = () => {
  const count = useSelector((state) => state.counter.count);
  const dispatch = useDispatch();

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => dispatch(increment())}>+1</button>
      <button onClick={() => dispatch(incrementByAmount(5))}>+5</button>
      <button onClick={() => dispatch(reset())}>Reset</button>
    </div>
  );
};

export default Counter;
```

---

## 정리

> `Redux Toolkit`은 상태와 상태 변경 함수를 하나로 묶어 관리하게 해주는 편리한 리덕스.  
> 액션 타입 정의, 액션 생성자 작성, switch 문 작성, 불변성 관리는 `Redux Toolkit`이 대신 해주니까 개발자는 **상태의 초기값을 정의하고 상태를 바꾸는 로직만 작성**하면 된다.
