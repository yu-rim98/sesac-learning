import React from "react";

function handleSubmit(event) {
  event.preventDefault();

  console.log(event.target.email.value);
  console.log(event.target.password.value);
}

// submit 이벤트는 form 태그만 발생함
const OnSubmit = () => {
  return (
    <div>
      <form action="" onSubmit={handleSubmit}>
        <input type="text" name="email" />
        <input type="password" name="password" />
        <input type="submit" value="제출" />
      </form>
    </div>
  );
};

export default OnSubmit;
