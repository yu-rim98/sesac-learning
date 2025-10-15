import { configureStore } from "@reduxjs/toolkit"; // 리듀서를 받아서 스토어를 생성하는 함수
import counterReducer from "./counterSlice"; // 리듀서 불러오기

// 스토어 생성
export const store = configureStore({
  reducer: {
    // counter : 상태 이름
    counter: counterReducer,
  },
});
