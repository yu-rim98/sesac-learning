import React from "react";
import LoginStatus from "./LoginStatus";
import AdminLink from "./AdminLink";

const Container = () => {
  return (
    <div>
      <LoginStatus isLogin={true} userName="홍길동" />
      <LoginStatus isLogin={false} userName="김철수" />
      <AdminLink isAdmin={true} />
      <AdminLink isAdmin={false} />
    </div>
  );
};

export default Container;
