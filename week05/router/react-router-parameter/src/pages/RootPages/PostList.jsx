import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const PostList = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    async function getPosets() {
      const response = await axios.get("https://dummyjson.com/posts");
      setPosts(response.data.posts);
    }

    getPosets();
  }, []);

  return (
    <div>
      게시글 목록
      <ul>
        {posts.map((post) => (
          <li>
            <Link key={post.id} to={`/posts/${post.id}`}>
              {post.title}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PostList;
