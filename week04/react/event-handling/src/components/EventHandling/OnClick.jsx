import React from "react";

const OnClick = () => {
  // 클릭 이벤트 핸들링 함수
  // 핸들링 함수명은 관례적으로 `handle이벤트명`으로 작성한다.
  function handleClick() {
    // 매개변수가 없는 함수
    alert("클릭");
  }

  function handleParamClick(param) {
    // 매개변수가 있는 함수
    alert(param);
  }

  return (
    <div>
      {/* 키멜 케이스로 이벤트 속성을 작성해야 한다 */}
      <button
        onClick={() => {
          handleClick();
        }}
      >
        화살표 함수 클릭
      </button>
      <button
        onClick={() => {
          handleParamClick("Hello World");
        }}
      >
        매개변수가 있는 화살표 함수 클릭
      </button>
      <button onClick={handleClick}>함수 참조 클릭</button>

      {/* <button onClick={handleParamClick("Hello World")}>
        **컴포넌트가 렌더링 시 바로 실행됨**
        매개변수가 있는 함수 참조 클릭
      </button> */}
    </div>
  );
};

export default OnClick;

// - onClick={() => { handleClick(); }} : 이벤트 발생 시 처리되어야 하는 로직이 하나 이상일 때, 함수가 매개변수를 받을 때
//    * 단순히 함수를 호출할 때 해당 방식을 사용하면 렌더링마다 새로운 handleClick() 함수 객체를 사용한다. - 불필요한 함수 재생성은 성능에 작은 오버헤드를 줄 수 있다.
// - onClick={handleClick} : 단순히 함수를 호출할 때 권장
//    * 매개변수를 받는 함수를 onClick={handleClick(2)} 방식으로 사용하면 컴포넌트가 렌더링될 때 **해당 함수가 즉시 실행**되기 때문에 화살표 함수를 사용해야 한다.
//    * 단순히 하나의 함수만 실행하는 것이 아니라 여러 작업을 함께 수행해야 할 때 화살표 함수를 사용한다.
