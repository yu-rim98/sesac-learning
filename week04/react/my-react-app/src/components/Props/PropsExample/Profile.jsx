import React from "react";

const Profile = ({ name, age, isAdmin }) => {
  return (
    <div>
      저는 {name}이고, {age}세 이며, 관리자 여부는
      {String(isAdmin)}
      입니다.
    </div>
  );
};

export default Profile;
