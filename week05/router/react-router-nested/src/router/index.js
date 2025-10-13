import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../layout/RootLayout";
import AuthLayout from "../layout/AuthLayout";
import Home from "../pages/RootPages/Home";
import About from "../pages/RootPages/About";
import Profile from "../pages/RootPages/Profile";
import AuthHome from "../pages/AuthPages/AuthHome";
import { Component } from "react";
import Login from "../pages/AuthPages/Login";
import Signup from "../pages/AuthPages/Signup";

const router = createBrowserRouter([
  // 중첩 라우팅 : 특정 부모 경로의 레이아웃이나 UI 틀을 공유하면서 그 안에서 자식 컴포넌트를 렌더링하고 싶을 때 사용한다.
  {
    path: "/",
    Component: RootLayout,
    children: [
      // 중첩할 자식 경로 객체를 정의하는 배열
      {
        index: true, // 부모 경로를 기본으로 사용
        Component: Home,
      },
      {
        path: "about",
        Component: About,
      },
      {
        path: "profile",
        Component: Profile,
      },
    ],
  },
  // AuthLayout 경로 설정
  // "/" 또는 "/auth" 경로가 들어오면 RootLayout, AuthLayout 컴포넌트를 보여준다. 이때 중첩 라우팅을 활용해서 이후 경로가 children에 정의한 경로와 일치하는 컴포넌트들을 보여준다.
  {
    path: "/auth",
    Component: AuthLayout,
    children: [
      {
        index: true,
        Component: AuthHome,
      },
      {
        path: "login",
        Component: Login,
      },
      {
        path: "signup",
        Component: Signup,
      },
    ],
  },
]);

export default router;
