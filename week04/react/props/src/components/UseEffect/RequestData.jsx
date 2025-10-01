import React, { useEffect, useState } from "react";
import axios from "axios";
import Product from "./product";

// 컴포넌트가 처음 마운트될 때 DummyJSON으로 데이터 요청
const RequestData = () => {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    async function getProducts() {
      const response = await axios.get("https://dummyjson.com/products");
      const data = response.data.products;

      setProducts(data);
    }
    getProducts();
  }, []); // 컴포넌트가 처음 마운트될 때 실행
  console.log(products);

  return (
    <div>
      {products.map((product) => (
        <Product key={product.id} product={product} />
      ))}
    </div>
  );
};

export default RequestData;
