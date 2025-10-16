import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";

const AuthLayout = () => {
  const token = useSelector((state) => state.auth.token);

  // 로그인 시 프로필 페이지
  if (token) {
    return <Navigate to="/profile" replace />;
  } else {
    return <Outlet />;
  }
};

export default AuthLayout;
