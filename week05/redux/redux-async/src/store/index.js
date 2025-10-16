import { configureStore } from "@reduxjs/toolkit";
import authSliceReducer from "./authSlice";
import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";
import {
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER,
} from "redux-persist";

// Persist Reducer 설정 변수
const authPersistConfig = {
  key: "auth", // localStorage key 이름
  storage: storage, // 저장 위치 (localStorage)
  whitelist: ["token"], // 어떤 상태를 저장할 것인가 -> token 상태만 저장
};

// Persist Reducer 생성
// Persist Reducer : 지속 가능한 리듀서를 생성하는 함수
// authPersistConfig : 설정
// authReducer : 원본 리듀서
const persistAuthReducer = persistReducer(authPersistConfig, authSliceReducer);

export const store = configureStore({
  reducer: {
    auth: persistAuthReducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }),
});

// Persist 스토어 생성 후 내보내기
export const persistor = persistStore(store);
