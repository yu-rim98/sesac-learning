import React, { useEffect, useState } from "react";
import { signup, resetIsSignup } from "../store/authSlice";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const isSignup = useSelector((state) => state.auth.isSignup);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  useEffect(() => {
    if (isSignup) {
      alert("회원가입되었습니다.");
      dispatch(resetIsSignup());
      navigate("/");
    }
  });
  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(signup({ email, password }));
  };
  return (
    <div>
      <h2>회원가입</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <input type="submit" value="회원가입" />
      </form>
    </div>
  );
};

export default Signup;
