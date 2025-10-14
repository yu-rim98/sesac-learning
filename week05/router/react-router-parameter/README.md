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

---

# React Router 파라미터

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

- Link 컴포넌트의 to prop에 템플릿 리터럴을 사용해 `/post/1, /post/2`와 같은 동적인 경로를 생성한다.

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

---

## 2. 쿼리 파라미터

> 리액트 라우터에서 쿼리 파라미터는 주로 목록의 정렬, 필터링, 페이지네이션 등 **부가적인 옵션을 URL에 표현**할 때 사용된다.  
> 즉, URL의 경로(path) 뒤에 `?`를 붙여 `key=value` 형태로 전달하는 데이터를 말하며 여러개일 경우 `&`로 연결한다.

- 예시 :
  - `/post?sort=asc&page=2`
  - `sort=asc` : sort라는 키에 asc 값을 가진다. (오름차순 정렬)
  - `page=2` : page키에 2라는 값을 가진다.(2페이지)

> **경로 파라미터**가 **특정 리소스(예: 특정 게시글)를 식별**하는데 사용되면 **쿼리 파라미터**는 그 **리소스를 어떻게 보여줄지**에 대한 '상태'나 '옵션'을 표현하는데 주로 사용된다.

## 핵심 개념 및 코드

1. 쿼리 파라미터 값 읽고 쓰기 (`useSearchParams` 훅)

   - `useSearchParams` 훅
     - 쿼리 파라미터를 다루기 위한 훅으로 `useState`와 유사하게 동작한다.
     - URL의 쿼리 문자열을 읽고, 변경할 수 있는 기능을 제공한다.

   ```javascript
   import { useSearchParams, Link } from "react-router-dom";

   function PostList() {
     // useSearchParams는 배열을 반환
     // 1. searchParams: 현재 쿼리 파라미터를 읽는 용도
     // 2. setSearchParams: 쿼리 파라미터를 변경하는 함수
     const [searchParams, setSearchParams] = useSearchParams();

     // URL이 /post?sort=desc 라면, sort 값('desc')을 가져옴
     const sortOrder = searchParams.get("sort");

     const handleSort = (order) => {
       // setSearchParams 함수로 쿼리 파라미터를 업데이트
       // 이 함수가 호출되면 URL이 변경되고 컴포넌트가 리렌더링된다.
       setSearchParams({ sort: order });
     };

     return (
       <div>
         {/* 버튼 클릭으로 URL의 쿼리 파라미터를 변경 */}
         <button onClick={() => handleSort("asc")}>오름차순</button>
         <button onClick={() => handleSort("desc")}>내림차순</button>
       </div>
     );
   }
   ```

   - `const [searchParams, setSearchParams] = useSearchParams();`
     - `searchParams` : `URLSearchParams` 객체. `.get('key')`메서드로 특정 쿼리 파라미터의 값을 읽을 수 있다.
     - `setSearchParams`: 쿼리 파라미터를 업데이트하는 함수. 객체를 인자로 전달하면 `?key=value`형태로 URL이 변경된다.
       - ex : `setSearchParams({ sort: 'asc', page: 1 })` -> `?sort=asc&page=1`
   - 값 읽기 (`searchParams.get('sort')`)
     - 현재 URL의 쿼리 문자열에서 sort 키의 값을 가져온다.
     - 만약 URL에 해당 쿼리가 없으면 null을 반환한다.
   - 값 변경 (`setSearchParams({ sort: order })`)
     - `setSearchParams` 함수를 호출하면 라우터가 **현재 URL의 쿼리 문자열을 인자로 받은 객체의 내용으로 변경**한다.
   - 이 과정에서 페이지는 새로고침되지 않고 컴포넌트만 새로운 `searchParams` 값으로 리렌더링 된다.

### 쿼리 스트링 API 호출 예시 흐름 정리

> setSearchParams({ sort: "asc" }) 호출   
> → URL의 쿼리 문자열 (?sort=asc) 변경   
> → 컴포넌트 리렌더링   
> → useSearchParams().get("sort") 값이 변경됨   
> → useEffect([sort])가 이를 감지   
> → API를 다시 요청   
> → 새 데이터를 받아서 상태(state)에 저장   
> → 화면이 새 데이터로 다시 렌더링됨   
