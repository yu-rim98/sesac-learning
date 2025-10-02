import React from "react";

const Product = ({ product }) => {
  return (
    <div>
      <p>title : {product.title}</p>
      <p>description : {product.description}</p>
    </div>
  );
};

export default Product;
