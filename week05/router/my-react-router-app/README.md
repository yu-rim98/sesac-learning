# 라우팅(Routing)이란?

## 기본 개념

> **라우팅(Routing)** 이란 사용자가 어떤 **경로(URL)** 로 접근했는지에 따라 화면에 보여줄 컴포넌트를 결정하는 것을 말한다.  
> 리액트 같은 **SPA(Single Page Application)** 에서는 페이지 이동 시 **새로고침 없이 화면을 바꿔야 하기 때문에** 브라우저의 URL을 감지해 그에 맞는 컴포넌트를 보여주는 **라우터 라이브러리**가 필요하다.

## React Router의 역할

> 리액트에서는 기본적으로 페이지 이동이 불가능하기 때문에 React Router와 같은 라이브러리를 사용해 URL에 따라 다른 컴포넌트를 보여준다.  
> 대표적으로 사용하는 라우터는 `react-router-dom`이다.

## React Router 구조 설정 (v7 기준)

```javascript
import { createBrowserRouter } from "react-router-dom";

const router = createBrowserRouter([
  {
    path: "/",
    Component: Home,
  },
  {
    path: "/about",
    Component: About,
  },
  {
    path: "/profile",
    Component: Profile,
  },
]);
```

- `createBrowserRouter`를 사용해 라우터를 생성하고 각 경로(`path`)에 따라 어떤 컴포넌트를 렌더링할지 지정한다.
- 위처럼 설정하면 URL이 `/about`일 때 `<About />`, `/profile`일 때 `<Profile />` 컴포넌트가 화면에 나타나게 된다.
- 주의 : `Component`는 함수 자체를 넘기는 거고 `element`는 `<About />`과 같은 JSX 넘기기 때문에 혼용하면 문제가 생길 수 있다.

---

## `<Link />` 컴포넌트

> 기존의 `<a href="">` 태그처럼 보이지만, **전체 페이지 리로딩 없이 SPA 방식으로 이동**시켜준다.  
> 즉, URL은 변경되지만 페이지는 리로드하지 않고 컴포넌트만 바뀜

```javascript
<Link to="/about">소개</Link>
```

- 전체 페이지를 새로고침하지 않아 속도가 빠르고, 리로딩을 하지 않기 때문에 기존 상태를 유지할 수 있다.
- React 18 이후 SSR 지원

---

## `<NavLink />` 컴포넌트

> `<Link>`와 동일한 역할을 하지만 현재 URL과 링크의 경로가 일치하면 자동으로 스타일을 적용해준다.  
> 현재 URL이 `/about`이면 `/about`에 연결된 `<NavLink>`는 활성화되어 특정 스타일을 줄 수 있다.

```javascript
<NavLink
  to="/about"
  className={({ isActive }) =>
    isActive ? "text-red-900 font-bold text-5xl" : ""
  }
>
  소개
</NavLink>
```

- `className`이나 `style`에 함수 형태를 넘기면 `isActive` 값을 받아올 수 있다.
- 현재 경로와 일치하면 자동으로 `isActive === true`

---

## `<Navigate />` / `<useNavigate />`

### Navigate 컴포넌트

- 특정 조건에서 **자동으로 다른 페이지로 이동**시키고 싶을 때 사용한다.

```javascript
if (!isLogin) {
  return <Navigate to="/" replace />;
}
```

- `replace` : 브라우저 히스토리 기록을 남기지 않음 (뒤로가기 방지)

### useNavigate 컴포넌트

- **버튼 클릭처럼 프로그래밍적으로 이동**할 때 사용

```javascript
const navigate = useNavigate();

<button onClick={() => navigate("/")}>홈페이지로 이동</button>;
```
