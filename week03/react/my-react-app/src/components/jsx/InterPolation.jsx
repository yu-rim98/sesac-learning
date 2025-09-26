import React from "react";

export default function InterPolation() {
  const number = 10;

  function greet(name) {
    return <p className="text-red-400 font-bold">저는 {name} 입니다.</p>;
  }
  return (
    <div>
      {/* JSX 보간법(Interpolation) */}
      <p>{1 + 1}</p>
      <p>{2 * 2}</p>
      <p>{1 === 1}</p>
      <p>{1 > 2}</p>
      <p>{number}</p>
      {greet("홍길동")}
    </div>
  );
}
