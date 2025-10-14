# React Router 파라미터

## 1. 경로 파라미터

> 웹 애플리케이션에서 특정 데이터를 식별하기 위해 URL 경로의 일부를 변수처럼 사용하는 기능이다.  
> 예시 : `/post/1`, `/post/2` 처럼 각기 다른 게시글 상세 페이지를 보여주고 싶을 때 숫자 1과 2가 파라미터가 됨  
> 파라미터를 통해 하나의 컴포넌트로 여러 다른 내용을 동적으로 보여줄 수 있다.

## 핵심 개념 및 코드

1. 파라미터를 받는 라우트 설정

   - 라우트 설정 시 특정 경로에 `:postId` 부분이 `postId` 이름의 파라미터를 받겠다는 선언이다.
   - `:(콜론)` 뒤에 변수명(postId)을 작성해 '해당 위치에 오는 값을 postId라는 파라미터로 사용하겠다'고 라우터에 설정함

   ```javascript
   const router = createBrowserRouter([
     {
       path: "/",
       element: <RootLayout />,
       children: [
         // ... 다른 라우트들
         {
           path: "/post",
           element: <PostList />,
         },
         {
           // 해당 부분
           path: "/post/:postId",
           element: <PostDetail />,
         },
       ],
     },
   ]);
   ```

2. 파라미터가 포함된 링크 생성

   - 게시글 목록 페이지에서는 각 게시글로 이동하는 링크를 만들어야 하며 이때 정의한 파라미터 자리에 실제 데이터(postId)를 넣어준다.

   ```javascript
   import { Link } from "react-router-dom";

   function PostList() {
     const posts = [
       { id: 1, title: "첫 번째 게시글" },
       { id: 2, title: "두 번째 게시글" },
     ];

     return (
       <ul>
         {posts.map((post) => (
           <li key={post.id}>
             {/* to 속성에 실제 post.id 값을 넣어 동적 URL을 생성 */}
             <Link to={`/post/${post.id}`}>{post.title}</Link>
           </li>
         ))}
       </ul>
     );
   }
   ```

   - Link 컴포넌트의 to prop에 템플릿 리터럴을 사용해 `/post/1`, `/post/2`와 같은 동적인 경로를 생성한다.

3. 컴포넌트에서 파라미터 값 사용하기

   - 상세 페이지 컴포넌트에서는 URL에 포함된 파라미터 값을 가져와 사용해야 하며 이때 `useParams` 훅을 사용한다.

   ```javascript
   import { useParams } from "react-router-dom";

   function PostDetail() {
     // useParams()는 URL 파라미터들을 객체 형태로 반환 { postId: '1' }
     const { postId } = useParams();

     return (
       <div>
         <h1>게시글 상세 페이지</h1>
         <p>현재 보고 있는 게시글의 ID는 {postId}입니다.</p>
       </div>
     );
   }
   ```

   - `useParams` 훅을 호출하면 **라우트 설정 시 정의했던 파라미터 이름(postId)** 을 **키(key)** 로 **URL의 실제 값**을 **값(value)으로 갖는 객체**를 반환한다.
   - 객체 구조 분해 할당을 통해 `postId` 값을 간편하게 추출하여 컴포넌트 내에서 변수처럼 사용할 수 있다.

## 리액트 라우터 파라미터 핵심 흐름

1. 정의

   - 라우터 설정에서 `path: '/post/:id`와 같이 콜론(:)을 이용해 파라미터를 받을 경로를 정의한다.

2. 생성

   - `Link` 컴포넌트에서 `to={'/post/1'}`처럼 실제 값이 포함된 URL로 이동하는 링크를 만든다.

3. 사용

   - 연결된 컴포넌트에서 `useParams` 훅을 사용해 URL의 파라미터 값을 가져와 동적인 콘텐츠를 렌더링한다.
