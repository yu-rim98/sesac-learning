import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../layout/RootLayout";
import AuthLayout from "../layout/AuthLayout";
import ProtectedLayout from "../layout/ProtectedLayout";
import Home from "../pages/RootPages/Home";
import About from "../pages/RootPages/About";
import Profile from "../pages/RootPages/Profile";
import AuthHome from "../pages/AuthPages/AuthHome";
import Login from "../pages/AuthPages/Login";
import Signup from "../pages/AuthPages/Signup";
import rootRoutes from "./routes/rootRoutes";
import authRoutes from "./routes/authRoutes";
import NotFound from "../pages/NotFound";

const router = createBrowserRouter([
  // 중첩 라우팅 : 특정 부모 경로의 레이아웃이나 UI 틀을 공유하면서 그 안에서 자식 컴포넌트를 렌더링하고 싶을 때 사용한다.

  // 스프레드 연산자로 경로 배열 복사
  ...rootRoutes,
  ...authRoutes,

  // * : 모든 것에 매핑을 의미함
  // 매핑된 컴포넌트가 없을 경우 NotFound 페이지를 보여줌
  {
    path: "*",
    Component: NotFound,
  },
]);

export default router;
