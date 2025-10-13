import React from "react";
import { Link, NavLink } from "react-router-dom";

const About = () => {
  return (
    <div>
      {/* NavLink : 현재 URL과 경로가 일치할 경우 자동으로 스타일을 적용해줌 */}

      <NavLink
        to="/"
        className={({ isActive }) =>
          isActive ? "text-red-900 font-bold text-5xl" : ""
        }
      >
        홈
      </NavLink>
      <br />

      {/* 현재 URL이 /about일 때 이 링크에 기본적으로 "active" 클래스가 자동으로 붙음 */}
      {/* isActive: 현재 경로와 링크의 경로가 일치하면 true */}
      <NavLink
        to="/about"
        className={({ isActive }) =>
          isActive ? "text-red-900 font-bold text-5xl" : ""
        }
      >
        소개
      </NavLink>
      <br />
      <NavLink
        to="/profile"
        className={({ isActive }) =>
          isActive ? "text-red-900 font-bold text-5xl" : ""
        }
      >
        프로필
      </NavLink>
    </div>
  );
};

export default About;
