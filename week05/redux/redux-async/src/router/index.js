import { Component } from "react";
import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Signup from "../pages/Signup";
import Profile from "../pages/Profile";
import PrivateLayout from "../layouts/PrivateLayout";
import AuthLayout from "../layouts/AuthLayout";

// 라우터 설정
const router = createBrowserRouter([
  {
    path: "/",
    Component: Home,
  },
  {
    Component: AuthLayout,
    children: [
      {
        path: "/login",
        Component: Login,
      },
      {
        path: "signup",
        Component: Signup,
      },
    ],
  },
  {
    Component: PrivateLayout,
    children: [
      {
        path: "/profile",
        Component: Profile,
      },
    ],
  },
]);

export default router;
