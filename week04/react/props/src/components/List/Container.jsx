import React from "react";
import User from "./User";

const Container = () => {
  const array = [1, 2, 3, 4, 5];

  const userArray = [
    { id: 1, name: "우영" },
    { id: 2, name: "길동" },
    { id: 3, name: "철수" },
    { id: 4, name: "짱구" },
    { id: 5, name: "영희" },
  ];

  return (
    <div>
      {array.map((array) => (
        <li>{array}</li>
      ))}

      {/* userArray map()을 활용해 반복 */}
      {userArray.map((user) => (
        <User user={user} />
      ))}
    </div>
  );
};

export default Container;
