import React from "react";
import { Link } from "react-router-dom"; // a 태그를 대체하는 컴포넌트

const Home = () => {
  return (
    <div>
      {/* to 속성 : 어디로 이동할 건지 지정 - 경로 매핑 */}
      <Link to="/">홈</Link>
      <br />
      <Link to="/about">소개</Link>
      <br />
      <Link to="/profile">프로필</Link>
    </div>
  );
};

export default Home;
