import React from "react";

function handleClick() {
  console.log("클릭됨");
}

const OnClick = () => {
  return (
    <div>
      {/* 아래 버튼을 클릭했을 때 handleClick 함수가 실행되도록 코드 작성 */}
      <button onClick={handleClick}>클릭</button>
    </div>
  );
};

export default OnClick;
