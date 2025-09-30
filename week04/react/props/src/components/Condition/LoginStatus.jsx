import React from "react";

const LoginStatus = ({ isLogin, userName }) => {
  return (
    <div>
      <p>로그인 상태 : {isLogin ? "로그인 상태" : "비 로그인 상태"}</p>
      <button>{isLogin ? "로그아웃" : "로그인"}</button>

      <p>{isLogin ? `${userName}님 환영합니다.` : `로그인 해주세요.`}</p>
    </div>
  );
};

export default LoginStatus;
