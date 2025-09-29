import React from "react";
import Card from "./Card";

const CardContainer = () => {
  function handleClick(user) {
    console.log(user);
  }
  const user = {
    name: "홍길동",
    age: 20,
  };

  return (
    <div>
      {/* Card 컴포넌트에 handleClick 함수 전달 */}
      {/* 함수 전달 시 함수의 이름만 전달해야 한다. */}
      <Card user={user} onClickProps={handleClick} />
    </div>
  );
};

export default CardContainer;
