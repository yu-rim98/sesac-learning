import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom";
import PATHS from "../../constants/Paths";

const PostList = () => {
  const [posts, setPosts] = useState([]);

  // useSearchParams 훅 : 쿼리 파라미터를 관리하는 훅
  // searchParams : 쿼리 파라미터 값을 가진 객체
  // setSearchParams : 쿼리 파라미터 값을 변경하는 함수
  const [searchParams, setSearchParams] = useSearchParams();

  useEffect(() => {
    const params = searchParams;

    // 쿼리 파라미터에서 키가 order인 값을 가져옴
    const order = params.get("order") ?? "asc"; // Nullish 연산자를 통해 기본값 지정
    const sortBy = params.get("sortBy") ?? "id"; // Nullish 연산자를 통해 기본값 지정

    async function getPosets() {
      const response = await axios.get(
        `https://dummyjson.com/posts?sortBy=${sortBy}&order=${order}`
      );
      setPosts(response.data.posts);
    }

    getPosets();
  }, [searchParams]);

  return (
    <div>
      게시글 목록
      <div className="flex gap-2">
        <button
          className="border-2 p-2 cusror-pointer"
          onClick={() => {
            setSearchParams({ sortBy: "id", order: "asc" });
          }}
        >
          ID 오름차순
        </button>
        <button
          className="border-2 p-2 cusror-pointer"
          onClick={() => {
            setSearchParams({ sortBy: "id", order: "desc " });
          }}
        >
          ID 내림차순
        </button>
      </div>
      <ul>
        {posts.map((post) => (
          <li>
            <Link key={post.id} to={PATHS.ROOT.getPostDetail(post.id)}>
              {post.title}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PostList;
