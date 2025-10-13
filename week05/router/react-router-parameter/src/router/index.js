import { createBrowserRouter } from "react-router-dom";
import RootLayout from "../layout/RootLayout";
import PostList from "../pages/RootPages/PostList";
import PostDetail from "../pages/RootPages/PostDetail";
import Home from "../pages/RootPages/Home";

const router = createBrowserRouter([
  {
    path: "/",
    Component: RootLayout,
    children: [
      {
        index: true,
        Component: Home,
      },
      {
        path: "posts",
        Component: PostList,
      },
      {
        path: "posts/:postId",
        Component: PostDetail,
      },
    ],
  },
]);

export default router;
