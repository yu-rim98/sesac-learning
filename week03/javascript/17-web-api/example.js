import axios from "axios";

const BASE_URL = "https://dummyjson.com/";

// 화살표 함수에 async
const testRoute = async () => {
  const response = await axios.get(`${BASE_URL}test`);

  console.log(response.data);
};

testRoute();

console.log("전체 상품 목록 조회");
const getAllProducts = async () => {
  const response = await axios.get(`${BASE_URL}products`);
  const data = response.data;
  const products = data.products;

  console.log(products);
};

getAllProducts();

console.log("단일 상품 조회");
const getProductById = async (n) => {
  // const data = (await axios.get(`${BASE_URL}${n}`)).data;
  const response = await axios.get(`${BASE_URL}products/${n}`);
  const data = response.data;
  console.log(data);
};

getProductById(1);
getProductById(3);
getProductById(5);

console.log("특정 상품 조회");
const searchProducts = async (productName) => {
  const queryParams = new URLSearchParams({ q: productName });
  const data = (await axios.get(`${BASE_URL}products/search?${queryParams}`))
    .data;

  console.log(data);
};

searchProducts("phone");
