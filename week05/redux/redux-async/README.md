# createAsyncThunk & extraReducers 정리

## 1. createAsyncThunk란

> 비동기 요청을 보내는 **함수**이자 해당 비동기 요청의 **상태(대기/성공/실패)를 자동으로 관리해주는 액션 생성기** 이다.

### 예시

```javascript
const login = createAsyncThunk("auth/login", async (data) => {
  const response = await axios.post("/login", data);
  return response.data;
});
```

- 위 코드로 **비동기 요청 함수 `login()`** 를 만들고 동시에 아래 **3개 액션이 자동으로 생성**된다.
  1. 요청 시작 (로딩) : `"auth/login/pending"`
  2. 요청 성공으로 종료 : `"auth/login/fulfilled"`
  3. 요청 실패로 종료 : `"auth/login/rejected"`

### 실행 과정

```javascript
dispatch(login({ email, password }));
```

- 위 코드 실행 시
  1.  pending 액션 발생
  2.  axios 요청 시도
  3.  성공 시 fulfilled 액션 발생 (데이터 전달)
  4.  실패 시 rejected 액션 발생 (에러 전달)
- 즉, createAsyncThunk는 비동기 함수 + 그 요청의 상태를 알려주는 3가지 액션을 자동으로 생성하는 도우미이다.

## 2. extraReducers란

> createAsyncThunk를 통해 자동으로 만들어진 액션들을 받아서 상태를 업데이트한다.

```javascript
extraReducers: (builder) => {
  builder
    .addCase(login.pending, (state) => {
      state.loading = true;
    })
    .addCase(login.fulfilled, (state, action) => {
      state.loading = false;
      state.token = action.payload.access_token;
    })
    .addCase(login.rejected, (state, action) => {
      state.loading = false;
      state.error = action.payload;
    });
},
```

> 즉, 요청 성공 시, 요청 실패 시의 리듀서 로직을 extraReducers에 적어두는 것

### 정리

1. `createAsyncThunk`

   - **비동기 요청 함수를 정의**할 수 있다.
   - `dispatch` 시점에 **요청이 실행**되고, **요청 상태에 따라 3가지 액션이 자동으로 발생**한다.

     - `pending` : 요청 시작 (대기 중)
     - `fulfilled` : 요청 성공 -> `payload`에 `return response.data` 담음
     - `rejected` : 요청 실패 -> `payload`에 `rejectWithValue(error.response.data)` 담음
     - 즉, 요청 결과를 `action.payload`에 자동으로 담아서 **리듀서로 전달**한다.

   - createAsyncThunk로 비동기 액션을 정의하면 미리 세가지 액션이 예약만 되는 거고 **실제 요청 진행 상태에 따라 동적으로 (dispatch 시점에) 발생**한다.

2. `extraReducers`
   - **3가지 액션이 발생했을 때 상태를 어떻게 바꿀건지 정의하는 리듀서**이다.
   - createAsyncThunk()가 발생시킨 액션(`pending`, `fulfilled`, `rejected`)을 처리하는 영역
   - `extraReducers`는 **외부 (비동기 thunk 등)에서 발생한 액션을 처리**한다.
   - 내부적으로 `switch(action.type)`처럼 동작한다.
