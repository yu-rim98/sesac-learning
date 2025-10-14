// 경로 문자열로 관리하기 위한 상수 객체
const PATHS = {
  // RootLayout에 중첩된 경로
  ROOT: {
    // RootLayout의 기본 경로 (진입점)
    INDEX: "/",
    ABOUT: "/about",

    PROFILE: "/profile",
  },

  // AuthLayout의 중첩된 경로
  AUTH: {
    INDEX: "/auth",
    LOGIN: "/auth/login",
    SIGNUP: "/auth/signup",
  },
};

export default PATHS;
