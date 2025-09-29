import React from "react";
import { Child } from "./Child";

const Parent = () => {
  return (
    <div>
      {/* 부모 컴포넌트에서 데이터를 전달해야 한다. - 자식 컴포넌트에게 */}
      {/* 즉, 자식 컴포넌트에서 사용할 데이터(속성)을 전달하는 것 */}
      {/* 데이터(props - 프로퍼티, 속성)를 전달하는 방법 */}
      {/* 문자열 속성은 " "로 전달하고, 숫자 속성은 { }로 전달한다.*/}
      <Child name="홍길동" age={23} />
      <Child name="김철수" age={25} />
      <Child name="홍영희" age={30} />
    </div>
  );
};

export default Parent;
