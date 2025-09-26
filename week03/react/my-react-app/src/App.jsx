import React from "react";

// default export (기본 내보내기)
// 파일(모듈) 내 하나의 컴포넌트 함수만 내보낼 수 있다.
// 컴포넌트 함수는 하나의 HTML 요소(Element)를 반환해야 한다.
export default function App() {
  // div 요소 3개 반환 -> 하나의 요소만 반환해야하므로 에러
  // return <div>App</div><dvi>2</dvi> <div>2</div>;
  return (
    <>
      <div>1</div>
      <div>2</div>
      <div>3</div>
    </>
  );
}
