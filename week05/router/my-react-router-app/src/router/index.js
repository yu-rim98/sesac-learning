import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import About from "../pages/About";
import Profile from "../pages/Profile";

const router = createBrowserRouter([
  {
    path: "/",
    Component: Home, // 런타임에 JSX 요소를 생성함
  },
  {
    path: "/about",
    Component: About,
    // 동시에 쓰면 우선순위가 꼬이거나, React Router의 라이프사이클 처리 로직이 깨짐 - 혼용 X
    // element: <About />, // 이전 버전에서는 컴포넌트 태그 자체를 지정
  },
  {
    path: "/profile",
    Component: Profile,
  },
]);

export default router;
