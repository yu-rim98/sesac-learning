import React from "react";
// 상태(State)를 사용하기 위한 모듈
import { useState } from "react";

// 리액트 훅(Hook)
const StateBasic = () => {
  const [somethingState, setSomethingState] = useState();
  const [something, setSomething] = useState();

  const [string, setString] = useState("초기값");

  const [array, setArray] = useState([1, 2, 3]);

  function handleClick() {
    setArray(array.concat(4));
    console.log("상태 변경");
  }

  return (
    <div>
      <button onClick={handleClick}>원소 추가</button>
      {array.map((e) => (
        <li>{e}</li>
      ))}
    </div>
  );
};

export default StateBasic;
