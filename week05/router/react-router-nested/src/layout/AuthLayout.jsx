import React from "react";
import { NavLink } from "react-router-dom";
import PATHS from "../constants/Paths";

const AuthLayout = () => {
  const baseClass = "text-blue-900 font-bold p-2";
  const activeClass = "border-2 border-red-900";

  return (
    <div>
      <div className="flex gap-2">
        <NavLink
          className={({ isActive }) =>
            `${baseClass} ${isActive ? activeClass : ""}`
          }
          to={PATHS.AUTH.INDEX}
          isActive
        >
          인증 홈페이지
        </NavLink>
        <NavLink
          className={({ isActive }) =>
            `${baseClass} ${isActive ? activeClass : ""}`
          }
          to={PATHS.AUTH.LOGIN}
        >
          로그인 페이지
        </NavLink>
        <NavLink
          className={({ isActive }) =>
            `${baseClass} ${isActive ? activeClass : ""}`
          }
          to={PATHS.AUTH.SIGNUP}
        >
          회원가입 홈페이지
        </NavLink>
      </div>
    </div>
  );
};

export default AuthLayout;
