import React, { useState } from "react";

const ArrayState = () => {
  const [array, setArray] = useState([{ id: 1, name: "철수" }]);

  const handleAdd = () => {
    const newId = array.length + 1;
    const newName = `친구 ${newId}`;

    const newArry = [...array, { id: newId, name: newName }];
    setArray(newArry);
  };
  return (
    <div>
      <ul>
        {array.map((element) => (
          <li key={element.id}>{element.name}</li>
        ))}
        <button onClick={handleAdd}>친구 추가</button>
      </ul>
    </div>
  );
};

export default ArrayState;
