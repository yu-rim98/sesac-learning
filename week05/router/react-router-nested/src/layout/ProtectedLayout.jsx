import React from "react";
import { Outlet, Navigate } from "react-router-dom";

// 비로그인 사용자는 로그인 페이지로 리디렉션
const ProtectedLayout = () => {
  const isLogin = true;

  if (!isLogin) {
    return <Navigate to="/auth/login" />;
  }
  return <Outlet />;
};

export default ProtectedLayout;
