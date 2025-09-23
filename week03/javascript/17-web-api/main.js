import axios from "axios"; // 모듈 불러와서 사용

// async/await
async function connectTest() {
  // 데이터 요청에 대한 응답 데이터를 반환
  const response = await axios.get(
    "https://jsonplaceholder.typicode.com/posts"
  );
  console.log(response.data);
}

connectTest();
