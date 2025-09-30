import React from "react";
import User from "./User";

const Container = () => {
  const array = [1, 2, 3, 4, 5];

  return (
    <div>
      {array.map((array) => (
        <li>{array}</li>
      ))}
    </div>
  );
};

export default Container;
