import React from "react";
import { useSelector } from "react-redux"; // 전역 상태를 불러오기 위한 훅 (useStete와 유사함)
import { useEffect } from "react";

// 전역 상태를 불러와서 화면에 표시하는 컴포넌트
const Counter = () => {
  // counter 전역 상태 불러오기
  const counter = useSelector((state) => state.counter);

  // 전역 상태 count
  const count = useSelector((state) => state.counter.count);

  useEffect(() => {
    // counter 상태 확인 : {count: 0}
    console.log(counter);
  });

  return <div>전역 상태 count의 값 : {count}</div>;
};

x0
