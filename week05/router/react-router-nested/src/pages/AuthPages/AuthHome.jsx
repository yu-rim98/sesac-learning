import React from "react";
import { Link } from "react-router-dom";

const AuthHome = () => {
  return (
    <div>
      인증 홈페이지
      <div className="flex flex-col gap-4">
        <Link to="/auth/login">로그인 페이지</Link>
        <Link to="/auth/signup">회원가입 페이지</Link>
      </div>
    </div>
  );
};

export default AuthHome;
