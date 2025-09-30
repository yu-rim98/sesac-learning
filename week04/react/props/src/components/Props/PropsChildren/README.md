# React `props.children` 개념 이해하기

> 리액트에서는 컴포넌트를 정의할 때 `<Component>...</Component>` **태그 사이에 들어가는 요소**들을 자동으로 **`props.children`** 이라는 prop으로 전달한다.  
> 해당 개념은 **컴포넌트 재사용성과 UI 컴포지션**의 핵심 개념이다.

```jsx
const Parent = () => {
  return (
    <div>
      <Child>
        <div>
          <h1>나는 길동</h1>
          <h2>20살</h2>
        </div>
      </Child>
    </div>
  );
};

const Child = ({ children }) => {
  return <div className="child-box">{children}</div>;
};
```

## `props.children` 이란?

- **`props.children`** 은 `<Component>...</Component>` 태그 사이의 **JSX 요소를 가리키는 prop** 이다.

```jsx
<div>
  <h1>나는 길동</h1>
  <h2>20살</h2>
</div>
```

- 위 JSX 전체가 `child` 컴포넌트의 `props.children`으로 전달된다.
  > 즉, `props`는 컴포넌트에 전달되는 모든 값들(속성)을 의미하며 `props.children`은 태그 사이의 내용(`<Component>여기</Component>`)을 의미한다. **JSX 요소도 props에 해당**한다.
