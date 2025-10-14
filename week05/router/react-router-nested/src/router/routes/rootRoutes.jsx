// RootLayout과 RootLayout에 중첩된 페이지 경로 배열 정의

import PATHS from "../../constants/Paths";
import ProtectedLayout from "../../layout/ProtectedLayout";
import RootLayout from "../../layout/RootLayout";
import About from "../../pages/RootPages/About";
import Home from "../../pages/RootPages/Home";
import Profile from "../../pages/RootPages/Profile";

const rootRoutes = [
  {
    path: PATHS.ROOT.INDEX,
    Component: RootLayout,
    children: [
      // 중첩할 자식 경로 객체를 정의하는 배열
      {
        index: true, // 부모 경로를 기본으로 사용
        Component: Home,
      },
      {
        path: PATHS.ROOT.ABOUT,
        Component: About,
      },
    ],
  },

  {
    Component: ProtectedLayout,
    // 보호할 경로와 컴포넌트 정의
    ///profile 경로는 ProtectedLayout을 먼저 렌더링한 다음
    // 로그인 상태일 경우 Outlet을 통해 Profile 컴포넌트를 보여준다
    children: [
      {
        path: PATHS.ROOT.PROFILE,
        Component: Profile,
      },
    ],
  },
];

export default rootRoutes;
