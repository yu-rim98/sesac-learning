import React from "react";

const User = ({ user }) => {
  return (
    <div>
      <li>
        {user.id} - {user.name}
      </li>
    </div>
  );
};

export default User;
