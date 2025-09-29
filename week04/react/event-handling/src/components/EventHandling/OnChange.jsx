import React from "react";

function handleChange(event) {
  console.log(event.target.value);
}

function handleNumberChange(event) {
  // 사용자 입력 값이 10보다 작으면 10보다 작은 수 출력
  const value = Number(event.target.value);

  if (value < 10) {
    console.log("10보다 작은 수");
  }
}

function handleNumberChange2(event) {
  // 사용자 입력 값이 10보다 작으면 10보다 작은 수 출력
  const value = Number(event.target.value);

  if (value < 10) {
    console.log("10보다 작은 수");
  }
}

const OnChange = () => {
  return (
    <div>
      {/* onChange 이벤트 속성 적용 */}
      <input
        type="number"
        onChange={(event) => {
          handleNumberChange(event);
        }}
      />

      <input type="number" onChange={handleNumberChange2} />
      <input
        type="text"
        onChange={(event) => {
          handleChange(event);
        }}
      />
    </div>
  );
};

export default OnChange;

//  - onChange={(event) => { handleNumberChange(event); }}
//  - onChange={handleNumberChange2}
// * 이벤트가 발생하면 React는 연결된 함수에 이벤트 객체를 자동으로 전달한다.
// * 따라서 함수 참조를 직접 넘기는(onChange={handleNumberChange2}) 방식이 더 효율적이고 깔끔하다.
