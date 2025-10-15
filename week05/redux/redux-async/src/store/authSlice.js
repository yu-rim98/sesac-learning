import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

// 로그인 요청을 보낼 인증 서버에 대한 정보
const SUPABASE_URL = "https://jfsjmxtokcazzpykrxwp.supabase.co";
const SUPABASE_ANON_KEY =
  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Impmc2pteHRva2NhenpweWtyeHdwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjAyMDE4NjksImV4cCI6MjA3NTc3Nzg2OX0.n-IAryEgUti5atr30MGszQ-fzStuW3BZDRMuaPPIefw";

const signup = createAsyncThunk(
  "auth/signup", // 액션 타입을 만들 때 사용되는 접두사
  async (data, { rejectWithValue }) => {
    try {
      // API 요청을 위한 설정
      const config = {
        url: `${SUPABASE_URL}/auth/v1/signup`,
        method: "POST",
        headers: {
          "Content-type": "application/json",
          apikey: SUPABASE_ANON_KEY,
        },
        data: {
          // 회원가입 데이터
          email: data.email,
          password: data.password,
        },
      };

      // API 요청
      const response = await axios(config);

      // 요청 성공 시 응답 데이터 반환
      return response.data;
    } catch (error) {
      // 에러 시 실행
      return rejectWithValue(error.response.data);
    }
  }
);

const login = createAsyncThunk(
  "auth/login",
  async (data, { rejectWithValue }) => {
    try {
      // API 요청을 위한 설정
      const config = {
        url: `${SUPABASE_URL}/auth/v1/token?grant_type=password`,
        method: "POST",
        headers: {
          "Content-type": "application/json",
          apikey: SUPABASE_ANON_KEY,
        },
        data: {
          // 회원가입 데이터
          email: data.email,
          password: data.password,
        },
      };
      const response = await axios(config);
      console.log(response.data);
      return response.data;
    } catch (error) {
      return rejectWithValue(error.response.data);
    }
  }
);

const initialState = {
  token: null,
  error: null,
  isSignup: false,
};

const authSlice = createSlice({
  name: "auth",
  initialState: initialState,
  reducers: {
    // 회원가입 여부를 false로 변경
    resetIsSignup: (state) => {
      state.isSignup = false;
    },
  },

  extraReducers: (builder) => {
    builder
      // API 요청 상태가 성공 액션 타입과 일치하다면
      .addCase(signup.fulfilled, (state) => {
        state.isSignup = true;
      })
      // API 요청 상태가 실패 액션 타입과 일치하다면
      .addCase(signup.rejected, (state, action) => {
        state.error = action.payload;
      })
      .addCase(login.fulfilled, (state, action) => {
        //return response.data의 값을 action.payload에 담아서 액션 생성
        state.token = action.payload.access_token;
      })
      .addCase(login.rejected, (state, action) => {
        state.error = action.payload;
      });
  },
});

export const { resetIsSignup } = authSlice.actions;
export default authSlice.reducer;

export { signup, login };
