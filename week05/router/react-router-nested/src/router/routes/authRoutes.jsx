import AuthLayout from "../../layout/AuthLayout";
import AuthHome from "../../pages/AuthPages/AuthHome";
import Login from "../../pages/AuthPages/Login";
import Signup from "../../pages/AuthPages/Signup";

// AuthLayout 경로 설정
// "/" 또는 "/auth" 경로가 들어오면 RootLayout, AuthLayout 컴포넌트를 보여준다. 이때 중첩 라우팅을 활용해서 이후 경로가 children에 정의한 경로와 일치하는 컴포넌트들을 보여준다.
const authRoutes = [
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
];

export default authRoutes;
