import { createSlice } from "@reduxjs/toolkit";

// 초기 전역 상태
const initialState = {
  count: 0,
};

// 슬라이스 생성 -> 리듀서와 액션을 생성함
const counterSlice = createSlice({
  name: "counter",
  initialState: initialState, // 초기 상태 정의 속성
  // 리듀서와 액션을 정의
  reducers: {
    // 어떤 행동을 할 건지 (액션) 작성 -> 상태 count를 1 증가시키는 리듀서와 액션 작성
    increment: (state) => {
      // 매개변수 state : 현재 슬라이스에 정의된 상태 -> count
      state.count = state.count + 1; // 상태를 직접 수정 -> Immer 객체가 불변성을 지켜줌
    },

    // 상태 count를 특정 값(입력 값)만큼 증가시키는 리듀서와 액션
    incrementByAmount: (state, action) => {
      // 매개변수 action : 상태를 어떻게 변경할지 정보(무엇을, 어떻게, 얼마만큼)를 저장한 객체
      // payload 속성의 값은 문자열이므로 형변환 필요함
      state.count = state.count + Number(action.payload);
    },

    // 상태 count를 0으로 만드는 리듀서와 액션
    reset: (state) => {
      state.count = 0;
    },
  },
});

// 액션 내보내기
export const { increment, incrementByAmount, reset } = counterSlice.actions;

// 리듀서 내보내기
export default counterSlice.reducer;
