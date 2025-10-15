import React from "react";

// counterSlice에서 increment 액션 생성자 함수 가져옴
import { increment } from "../store/counterSlice";

// useDispatch() 훅 : dispatch 함수를 생성하는 훅
// dispatch : 액션을 스토어로 보내는 함수
import { useDispatch } from "react-redux";

const CounterIncrement = () => {
  const dispatch = useDispatch();

  const clickHandler = () => {
    // 액션 생성 후 확인
    // {type: 'counter/increment', payload: undefined}
    // const action = increment();
    // console.log(action);

    // dispatch로 액션 생성자 함수 전달
    dispatch(increment()); // 생성된 액션 함수를 dispatch로 전달함
  };
  return (
    <div>
      <button onClick={clickHandler}>1 증가</button>
    </div>
  );
};

export default CounterIncrement;
