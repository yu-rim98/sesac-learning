import React from "react";
import Profile from "./Profile";

const ProfileContainer = () => {
  // const name = "현우";
  // const age = 22;
  // const isAdmin = true;
  const user = {
    name: "현우",
    age: 22,
    isAdmin: true,
  };

  return (
    <div>
      {/* <Profile name="현우" age={22} isAdmin={true} /> */}
      <Profile user={user} />
      {/* <Profile name="수진" age={21} isAdmin={false} /> */}
    </div>
  );
};

export default ProfileContainer;
