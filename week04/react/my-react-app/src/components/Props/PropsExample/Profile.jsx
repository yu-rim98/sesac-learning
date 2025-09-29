import React from "react";

const Profile = (props) => {
  return (
    <div>
      저는 {props.name}이고, {props.age}세 이며, 관리자 여부는
      {String(props.isAdmin)}
      입니다.
    </div>
  );
};

export default Profile;
