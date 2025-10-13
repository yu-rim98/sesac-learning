import React from "react";
import { NavLink } from "react-router-dom";

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
          to="/auth"
          isActive
        >
          인증 홈페이지
        </NavLink>
        <NavLink
          className={({ isActive }) =>
            `${baseClass} ${isActive ? activeClass : ""}`
          }
          to="/auth/login"
        >
          로그인 페이지
        </NavLink>
        <NavLink
          className={({ isActive }) =>
            `${baseClass} ${isActive ? activeClass : ""}`
          }
          to="/auth/signup"
        >
          회원가입 홈페이지
        </NavLink>
      </div>
    </div>
  );
};

export default AuthLayout;
