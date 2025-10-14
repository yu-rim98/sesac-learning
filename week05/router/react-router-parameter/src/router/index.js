import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../layout/RootLayout";
import PostList from "../pages/RootPages/PostList";
import PostDetail from "../pages/RootPages/PostDetail";
import Home from "../pages/RootPages/Home";

import PATHS from "../constants/Paths";

const router = createBrowserRouter([
  {
    path: PATHS.ROOT.INDEX,
    Component: RootLayout,
    children: [
      {
        index: true,
        Component: Home,
      },
      {
        path: PATHS.ROOT.POSTS,
        Component: PostList,
      },
      {
        path: PATHS.ROOT.POST_DETAIL,
        Component: PostDetail,
      },
    ],
  },
]);

export default router;
