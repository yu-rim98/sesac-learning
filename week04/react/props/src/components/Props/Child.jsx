import React from "react";

// 함수의 첫번째 매개변수는 props 객체가 들어온다. - props 객체로 받기
export const Child = (props) => {
  return (
    <div>
      <h1>{props.name}</h1>
      <h2>{props.age}</h2>
    </div>
  );
};
