import React, { useState } from "react";

// age: 19,
// name: "홍길동",
const ObjectState = () => {
  const [objectState, setObjectState] = useState({ age: 19, name: "홍길동" });

  const updateObjectState = () => {
    // 기존 객체 속성 복사(스프레드 연산자), age만 새로운 값으로 덮어씀
    const newObjectState = { ...objectState, age: objectState.age + 1 };
    setObjectState(newObjectState);
  };

  const deleteObjectState = () => {
    // 구조 분해 할당
    // objectState에서 age를 제외한 나머지 객체 속성과 값을 복사한다.
    const { age, ...newObjectState } = objectState;
    setObjectState(newObjectState);
  };

  return (
    <div>
      <p>이름: {objectState.name}</p>
      <p>나이: {objectState.age || "없음"}</p>
      <button onClick={updateObjectState}>나이 증가</button> <br />
      <button onClick={deleteObjectState}>나이 제거</button>
    </div>
  );
};

export default ObjectState;
