import React from "react";

const AdminLink = ({ isAdmin }) => {
  return (
    <div>
      <p>현재 권한 : {isAdmin ? "관리자" : "일반 사용자"}</p>
      <p>{isAdmin && <a className="text-red-500">관리 페이지 이동</a>}</p>
    </div>
  );
};

export default AdminLink;
