import axios from "axios";
import React, { useEffect, useState } from "react";
// 주소 경로 파라미터를 불러오는 훅 (/posts/:postId) - postId
import { useParams } from "react-router-dom";

const PostDetail = () => {
  // 파라미터 값 가져오기
  // 라우터에서 설정한 파라미터명과 동일한 변수명을 사용해야 함
  const { postId } = useParams();
  const [post, setPost] = useState([]);

  useEffect(() => {
    getPost();
  }, [postId]);

  const getPost = async () => {
    const response = await axios.get(`https://dummyjson.com/posts/${postId}`);
    setPost(response.data);
  };

  return (
    <div>
      <h2>글 제목 : {post.title}</h2>
      <p>내용 : {post.body}</p>
    </div>
  );
};

export default PostDetail;
