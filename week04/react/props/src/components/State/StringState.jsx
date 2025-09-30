import React, { useState } from "react";

const StringState = () => {
  // 초기 값이 문자열 ""인 상태를 생성한다
  const [stringState, setStringState] = useState("");

  const updateStringState = () => {
    let newString = `${stringState} 추가`;
    setStringState(newString);
  };

  return (
    <div>
      <p>{stringState}</p>
      <button onClick={updateStringState}>문자열 추가</button>
    </div>
  );
};

export default StringState;
