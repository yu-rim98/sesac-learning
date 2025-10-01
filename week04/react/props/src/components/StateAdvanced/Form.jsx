import React, { useState } from "react";

const Form = () => {
  const [form, setForm] = useState({
    username: "",
    age: 0,
    email: "",
  });

  const handleChange = (event) => {
    const { name, value } = event.target;

    const newForm = { ...form, [name]: value };

    setForm(newForm);
  };

  return (
    <div>
      <form>
        {/* 3개 input 요소의 값을 상태로 관리 */}
        <input
          className="border-2"
          type="text"
          name="username"
          value={form.name}
          onChange={handleChange}
        />
        <input
          className="border-2"
          type="number"
          name="age"
          value={form.age}
          onChange={handleChange}
        />
        <input
          className="border-2"
          type="email"
          name="email"
          value={form.email}
          onChange={handleChange}
        />
      </form>
    </div>
  );
};

export default Form;
