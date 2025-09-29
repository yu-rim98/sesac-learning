import React from "react";
import Profile from "./Profile";

const ProfileContainer = () => {
  return (
    <div>
      <Profile name="현우" age={22} />
      <Profile name="수진" age={21} />
    </div>
  );
};

export default ProfileContainer;
