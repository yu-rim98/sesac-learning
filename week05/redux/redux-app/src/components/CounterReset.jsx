import React from "react";
import { reset } from "../store/counterSlice";
import { useDispatch } from "react-redux";

const CounterReset = () => {
  const dispatch = useDispatch();

  return (
    <div>
      <button
        onClick={() => {
          dispatch(reset());
        }}
      >
        초기화
      </button>
    </div>
  );
};

export default CounterReset;
