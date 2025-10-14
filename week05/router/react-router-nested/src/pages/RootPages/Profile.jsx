import React from "react";
import { Navigate, useNavigate } from "react-router-dom";
import PATHS from "../../constants/Paths";

const Profile = () => {
  // 로그인 상태
  const isLogin = true;

  // useNavigate
  const navigate = useNavigate();

  // 로그인 상태가 아니면 "/"로 리디렉션
  if (!isLogin) {
    // <Navigate> 컴포넌트를 반환
    // replace : history(사용자가 접속한 기록)에 남지 않음
    return <Navigate to={PATHS.ROOT.INDEX} replace />;
  }

  return (
    <div>
      사용자 정보
      <button
        onClick={() => {
          alert("홈페이지로 이동합니다.");
          navigate("/");
        }}
        className="border p-2"
      >
        홈페이지로 이동
      </button>
    </div>
  );
};

export default Profile;
