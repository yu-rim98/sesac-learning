import React from "react";
import { useEffect } from "react";
import { useState } from "react";

import axiosInstance from "../../api";

const MovieList = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const config = {
        method: "GET",
        url: `/movie/popular`,
        params: {
          page: 1,
        },
      };

      const res = await axiosInstance(config);
      setMovies(res.data.results);
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
