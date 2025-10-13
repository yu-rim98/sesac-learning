import React, { useEffect, useState } from "react";

const Basic = () => {
  const [number, setNumber] = useState(0);
  const [number2, setNumber2] = useState(0);

  // 의존성 배열이 없는 경우에는 렌더링마다 실행됨
  useEffect(() => {
    console.log("의존성 배열이 없는 useEffect");
  });

  // 빈 배열일 때는 마운트 시 단 한번만 실행됨
  useEffect(() => {
    console.log("의존성 배열이 빈 배열인 useEffect");
  }, []);

  // number2의 값이 바뀔 때마다 실행됨
  useEffect(() => {
    console.log("의존성 배열이 number2인 useEffect");
  }, [number2]);

  return (
    <div>
      <button onClick={() => setNumber(number + 1)}>{number}</button>
      <button
        onClick={() => {
          setNumber2(number2 + 1);
        }}
      >
        {number2}
      </button>
    </div>
  );
};

export default Basic;
