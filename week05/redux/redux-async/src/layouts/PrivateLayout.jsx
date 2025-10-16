import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";

// 로그인 사용자만 접근 가능한 레이아웃
const PrivateLayout = () => {
  // 전역 상태 token 불러오기
  const token = useSelector((state) => state.auth.token);

  // 토큰이 없으면 (로그인하지 않은 상태) 로그인 페이지로 이동
  if (!token) {
    return <Navigate to="/login" replace />;
  } else {
    // 토큰이 있으면 중첩된 자식 컴포넌트를 렌더링
    return <Outlet />;
  }
};

export default PrivateLayout;
