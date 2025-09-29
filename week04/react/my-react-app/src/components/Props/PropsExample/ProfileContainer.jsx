import React from "react";
import Profile from "./Profile";

const ProfileContainer = () => {
  return (
    <div>
      {/* <Profile name="현우" age={22} isAdmin={true} /> */}
      <Profile user={{ name: "현우", age: 22, isAdmin: true }} />
      {/* <Profile name="수진" age={21} isAdmin={false} /> */}
    </div>
  );
};

export default ProfileContainer;
