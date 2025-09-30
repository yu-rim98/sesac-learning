import React, { useState } from "react";

const NumberState = () => {
  // 초기 값이 숫자 0인 상태를 생성한다
  const [numberState, setNumberState] = useState(0);

  const updateNumberState = () => {
    setNumberState(numberState + 1);
  };

  return (
    <div>
      <p>{numberState}</p>
      <button onClick={updateNumberState}>카운트 증가</button>
    </div>
  );
};

export default NumberState;
