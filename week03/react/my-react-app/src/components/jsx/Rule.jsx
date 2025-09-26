import React from "react";

// default export (기본 내보내기)
// 파일(모듈) 내 하나의 컴포넌트 함수만 내보낼 수 있다.
// 컴포넌트 함수는 하나의 HTML 요소(Element)를 반환해야 한다.
export default function Rule() {
  // div 요소 3개 반환 -> 하나의 요소만 반환해야하므로 에러
  // return <div>App</div><dvi>2</dvi> <div>2</div>;
  return (
    <>
      <div>1</div>
      <div>2</div>
      <div>3</div>
      {/* 닫는 태그가 필수 */}
      {/* <input> : 불가 */}

      {/* 속성명은 카멜케이스 : className="" onClick={}*/}
      <p className="font-bold text-red-900">p 태그</p>

      {/* style은 객체로 작성한다. : style={{key: value}} 형태 */}
      <p style={{ font: "bold", fontSize: "3rem" }}>p 태그</p>

      {/* {} 사이에 표현식을 삽입할 수 있음 */}
      <p>1 + 2 : {1 + 2}</p>
    </>
  );
}
