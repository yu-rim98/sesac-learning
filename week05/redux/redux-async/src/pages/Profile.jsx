import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";
import { logout } from "../store/authSlice";

// 로그인 상태에 전역 상태에 저장된 token 활용
const Profile = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  // 전역 상태 토큰
  const token = useSelector((state) => state.auth.token);

  // 로그인 검증 로직
  // 사용자 정보 관리 상태
  const [decodeToken, setDecodeToken] = useState(null);

  useEffect(() => {
    if (token) {
      setDecodeToken(jwtDecode(token));
    }
  }, [token]);

  const handleLogout = () => {
    dispatch(logout());
  };

  return (
    <div>
      <div>{token ? token : "로그인이 필요합니다."}</div>
      <div>
        {decodeToken ? `이메일 : ${decodeToken.email}` : "로그인이 필요합니다."}
      </div>
      <button className="border-2" onClick={handleLogout}>
        로그아웃
      </button>
    </div>
  );
};

export default Profile;
