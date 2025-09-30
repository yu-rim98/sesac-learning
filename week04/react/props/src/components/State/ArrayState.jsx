import React, { useState } from "react";

const ArrayState = () => {
  const [array, setArray] = useState([
    { id: 1, name: "철수" },
    { id: 2, name: "영희" },
    { id: 3, name: "동수" },
  ]);

  const handleAdd = () => {
    const newId = array.length + 1;
    const newName = `친구 ${newId}`;

    const newArry = [...array, { id: newId, name: newName }];
    setArray(newArry);
  };

  const handleRemove = () => {
    if (array.length < 1) {
      alert("삭제할 친구가 없습니다.");
      return;
    }

    const lastId = array.length;

    const newArry = array.filter((element) => {
      if (element.id !== lastId) {
        return true;
      }
    });

    setArray(newArry);
  };
  return (
    <div>
      <ul>
        {array.map((element) => (
          <li key={element.id}>{element.name}</li>
        ))}
        <button onClick={handleAdd}>친구 추가</button> <br />
        <button onClick={handleRemove}>친구 제거</button>
      </ul>
    </div>
  );
};

export default ArrayState;
