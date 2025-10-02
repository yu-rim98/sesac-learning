import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";

// 2번인

const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];
const BASE_URL = `https://api.themoviedb.org/3`;

const MovieDetail = () => {
  const [detail, setDetail] = useState([]);

  useEffect(() => {
    async function getMovieDetail() {
      const config = {
        method: "GET",
        url: `${BASE_URL}/movie/2`,
        headers: {
          "Content-Type": "application/json",
          accept: "application/json",
          Authorization: `Bearer ${API_KEY}`,
        },
        params: {
          language: "ko-KR",
        },
      };
      const res = await axios(config);
      setDetail(res.data);
    }

    getMovieDetail();
  }, []);

  return <div>영확 제목 : {detail.title}</div>;
};

export default MovieDetail;
