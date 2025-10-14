# Axios - 인터셉터 / 모듈화

## Axios

> 브라우저와 Node.js에서 사용 가능한 **Promise** 기반 HTTP 클라이언트이다.   
> 주로 API 서버와의 HTTP `요청`/`응답`을 **비동기적**으로 처리하기 위해 사용된다.   
> `fetch()`보다 사용하기 편하고 에러 핸들링과 `요청`/`응답 인터셉터와 같은 고급 기능을 지원한다.

## Axios 인스턴스 생성 후 재사용

```javascript
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
```

- 공통된 설정을 재사용하기 위해 커스텀 axios 인스턴스를 생성할 수 있다.
- `baseURL`, `headers`, `params` 등의 설정을 매번 요청마다 작성하지 않고, 한번 설정한 인스턴스를 재사용할 수 있다.
- API 요청이 많은 프로젝트에서 중복 코드 제거 및 유지보수성을 향상시킨다.

## 인터셉터(Interceptor)

```javascript
// 응답 인터셉터 : 서버가 사용자에게 응답으로 전달하는 데이터를 가로채 추가 작업을 수행
axiosInstance.interceptors.response.use(
  // 2개의 함수 전달
  // 요청 성공 시 함수
  (response) => {
    console.log("요청 성공 응답 인터셉터");
    return response.data;
  },

  // 요청 실패 시 함수
  (error) => {
    if (error.response) {
      if (error.response.status === 401) {
        alert("인증에 문제가 발생했습니다.");
      } else if (error.response.status === 404) {
        alert("페이지를 찾을 수 없습니다.");
      }
    }
    return Promise.reject(error);
  }
);
```

- 요청 또는 응답을 가로채서 가공 등의 처리를 할 수 있는 기능으로 공통적인 로직(로딩 처리, 에러 핸들링, 토큰 갱신 등)을 처리할 수 있다.
- `axiosInstance.interceptors.response.use()` 는 axios에서 제공하는 인터셉터 기능 메서드이다.

## API 요청 함수 모듈화

```javascript
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
```

- API 요청을 함수로 정의해 재사용 가능하게 모듈화할 수 있다.
- 현재 코드는 axiosInstance를 import 받아 axiosInstance에 요청하고 결과를 반환하는 함수이다.
- 요청에 필요한 설정을 함수로 모듈화해서 api 호출이 필요한 비즈니스 코드는 해당 함수를 호출만 하면 된다.

```javascript
import { getPopularMovies } from "../../api/tmdb";

const MovieList = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const res = await getPopularMovies();
      setMovies(res.results);
    }

    fetchData();
  }, []);

  return (
    <div>
      <h1>인기 영화 목록</h1>
      <ul>
        {movies.map((movie) => (
          <li key={movie.id}>{movie.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default MovieList;
```
