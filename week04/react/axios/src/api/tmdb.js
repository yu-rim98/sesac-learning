// TMDB API 요청 함수 관리 파일
// axios를 활용한 TMDB API 요청 함수를 별도로 정의하고, 내보내는 파일
import axiosInstance from "./index";

// TMDB Popular API 요청 함수 - 응답 데이터를 반환함
// 모듈 export
export async function getPopularMovies() {
  const config = {
    method: "GET",
    url: `/movie/popular`,
    params: {
      page: 1,
    },
  };

  return await axiosInstance(config);
}
