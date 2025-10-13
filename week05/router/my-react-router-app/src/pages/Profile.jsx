import React from "react";
import { Navigate } from "react-router-dom";

const Profile = () => {
  // 로그인 상태
  const isLogin = false;

  // 로그인 상태가 아니면 "/"로 리디렉션
  if (!isLogin) {
    // <Navigate> 컴포넌트를 반환
    // replace : history(사용자가 접속한 기록)에 남지 않음
    return <Navigate to="/" replace />;
  }
  return <div>사용자 정보</div>;
};

export default Profile;
