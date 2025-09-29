import React from "react";
import Profile from "./Profile";

const ProfileContainer = () => {
  const name = "현우";
  const age = 22;
  const isAdmin = true;
  return (
    <div>
      <Profile name="현우" age={22} isAdmin={true} />
      {/* <Profile name={name} age={age} isAdmin={isAdmin} /> */}
      <Profile name="수진" age={21} isAdmin={false} />
    </div>
  );
};

export default ProfileContainer;
