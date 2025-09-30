import React from "react";
import Child from "./Child";

const Parent = () => {
  return (
    <div>
      <Child>
        <div>
          <h1>나는 길동</h1>
          <h2>20살</h2>
        </div>
      </Child>
      <Child>
        <div>
          <h1>나는 철수</h1>
          <h2>떡잎마을방범대</h2>
        </div>
      </Child>
      <Child>
        <div>
          <h1>나는 짱구</h1>
          <h2>귀여워요</h2>
        </div>
      </Child>
    </div>
  );
};

export default Parent;
