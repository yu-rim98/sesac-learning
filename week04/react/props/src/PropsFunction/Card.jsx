import React from "react";

// props 구조
// props = {
//   user: { name: "홍길동", age: 20 },
//   onClickProps: handleClick,
// }

const Card = ({ user, onClickProps }) => {
  return (
    <div>
      {/* 부모 컴포넌트에서 onClickProps 키로 전달한 handleClick을 자식 컴포넌트의 요소에 onClick 이벤트와 연결한다. */}
      <button
        onClick={() => {
          onClickProps(user);
        }}
      >
        클릭
      </button>
    </div>
  );
};

export default Card;
