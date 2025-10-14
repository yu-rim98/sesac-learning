import React from "react";
import { Link } from "react-router-dom";
import PATHS from "../../constants/Paths";

const AuthHome = () => {
  return (
    <div>
      인증 홈페이지
      <div className="flex flex-col gap-4">
        <Link to={PATHS.AUTH.LOGIN}>로그인 페이지</Link>
        <Link to={PATHS.AUTH.SIGNUP}>회원가입 페이지</Link>
      </div>
    </div>
  );
};

export default AuthHome;
