import React, { useState } from "react";
import { incrementByAmount } from "../store/counterSlice";
import { useDispatch } from "react-redux";

// 사용자에게 입력받은 값만큼 전역 상태 count를 증가함
const CounterIncrementByAmount = () => {
  // dispatch 함수
  const dispatch = useDispatch();

  // 입력 요소의 상태
  const [payload, setPayload] = useState(0);

  return (
    <div>
      <input
        type="number"
        value={payload}
        onChange={(e) => setPayload(e.target.value)}
      />
      {/* payload를 인자로 받는 incrementByAmount() 함수를 생성하고 dispatch()로 전달 */}
      <button onClick={() => dispatch(incrementByAmount(payload))}>증가</button>
    </div>
  );
};

export default CounterIncrementByAmount;
