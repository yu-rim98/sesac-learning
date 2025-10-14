// 경로 문자열로 관리하기 위한 상수 객체
const PATHS = {
  // RootLayout에 중첩된 경로
  ROOT: {
    // RootLayout의 기본 경로 (진입점)
    INDEX: "/",
    POSTS: "/posts",
    POST_DETAIL: "/posts/:postId",
    // 경로 파라미터를 처리할 메서드
    getPostDetail: (postId) => `/posts/${postId}`,
  },
};

export default PATHS;
