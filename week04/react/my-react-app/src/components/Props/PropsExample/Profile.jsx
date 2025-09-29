import React from "react";

const Profile = (props) => {
  return (
    <div>
      저는 {props.user.name}이고, {props.user.age}세 이며, 관리자 여부는
      {String(props.user.isAdmin)}
      입니다.
    </div>
  );
};

export default Profile;
