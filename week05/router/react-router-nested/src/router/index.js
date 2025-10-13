import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../layout/RootLayout";
import Home from "../pages/RootPages/Home";
import About from "../pages/RootPages/About";
import Profile from "../pages/RootPages/Profile";

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
]);

export default router;
