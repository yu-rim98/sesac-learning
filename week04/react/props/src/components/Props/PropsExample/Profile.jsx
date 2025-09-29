import React from "react";

const Profile = ({ user }) => {
  return (
    <div>
      저는 {user.name}이고, {user.age}세 이며, 관리자 여부는
      {String(user.isAdmin)}
      입니다.
    </div>
  );
};

export default Profile;
