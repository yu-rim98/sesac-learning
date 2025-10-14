import React from "react";
import { Link, Outlet } from "react-router-dom";
import PATHS from "../constants/Paths";

const RootLayout = () => {
  return (
    <div>
      <div className="flex gap-4 p-2 border-2 border-gray-300">
        <Link to={PATHS.ROOT.INDEX}>홈페이지</Link>
        <Link to={PATHS.ROOT.POSTS}>게시글 목록</Link>
      </div>
      {/* 자식 컴포넌트가 중첩될 위치에 사용 */}
      <Outlet />
    </div>
  );
};

export default RootLayout;
