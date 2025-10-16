import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

// 로그인 요청을 보낼 인증 서버에 대한 정보 (환경변수)
const SUPABASE_URL = import.meta.env.VITE_SUPABASE_URL;
const SUPABASE_ANON_KEY = import.meta.env.VITE_SUPABASE_ANON_KEY;

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

const logout = createAsyncThunk(
  "auth/logout",
  async (_, { rejectWithValue, getState }) => {
    // rejectWithValue, getState - thunkAPI 메서드. 즉, Redux Toolkit이 자동으로 넘겨줌
    try {
      const config = {
        url: `${SUPABASE_URL}/auth/v1/logout`,
        method: "POST",
        headers: {
          "Content-type": "application/json",
          apikey: SUPABASE_ANON_KEY,
          // 토큰 정보
          Authorization: `Bearer ${getState().auth.token}`,
        },
      };
      const response = await axios(config);
      return response.data;
    } catch (error) {
      console.error(error);
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
      })
      .addCase(logout.fulfilled, (state) => {
        state.token = null;
      })
      .addCase(logout.rejected, (state, action) => {
        state.error = action.payload;
      });
  },
});

export const { resetIsSignup } = authSlice.actions;
export default authSlice.reducer;

export { signup, login, logout };
