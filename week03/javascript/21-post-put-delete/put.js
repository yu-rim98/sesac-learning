import axios from "axios";

async function putProduct(productId, productName) {
  const config = {
    url: `https://dummyjson.com/products/${productId}`,
    method: "put",
    headers: { "Content-Type": "application/json" },
    data: {
      title: productName,
    },
  };

  const response = await axios(config);

  console.log(response.data);
}

putProduct(2, "아이폰");
