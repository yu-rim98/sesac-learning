import axios from "axios";

const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];

// 커스텀 axios 인스턴스 생성
// 여러 곳에서 공통된 설정(baseURL, headers 등)을 사용하기 위해 axios 객체를 한번만 설정해 재사용할 수 있도록 한다.
// ex: axiosInstance.get("/posts") -> 실제 요청은 https://dummyjson.com/posts 로 날아감
const axiosInstance = axios.create({
  // 모든 요청에 기본으로 적용할 URL 앞부분
  baseURL: "https://api.themoviedb.org/3",

  // 요청 헤더 설정
  headers: {
    "Content-Type": "application/json",
    accept: "application/json",
    Authorization: `Bearer ${API_KEY}`,
  },
  params: {
    language: "ko-KR",
  },

  // 등등..
});

export default axiosInstance;
