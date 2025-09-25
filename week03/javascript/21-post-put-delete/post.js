import axios from "axios";

async function addProduct(productName, productPrice) {
  const URL = "https://dummyjson.com/products/add";
  const METHOD = "post";
  const body = {
    title: productName,
    price: productPrice,
  };

  const HEADERS = {
    "Content-Type": "application/json",
  };

  const config = {
    url: URL,
    method: METHOD,
    headers: HEADERS,
    data: body,
  };

  const response = await axios(config);
  console.log(response.data);
}

addProduct("아이폰 17", 20000000);
