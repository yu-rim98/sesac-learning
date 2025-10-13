import React from "react";
import { Link, Outlet } from "react-router-dom";

const RootLayout = () => {
  return (
    <div>
      <div className="flex gap-4 p-2 border-2 border-gray-300">
        <Link to="/">홈페이지</Link>
        <Link to="/about">소개페이지</Link>
        <Link to="/profile">사용자 정보 페이지</Link>
      </div>
      {/* 자식 컴포넌트가 중첩될 위치에 사용 */}
      <Outlet />
    </div>
  );
};

export default RootLayout;
