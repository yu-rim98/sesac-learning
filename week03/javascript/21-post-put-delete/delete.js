import axios from "axios";

async function deleteProduct(productId) {
  const response = await axios.delete(
    `https://dummyjson.com/products/${productId}`
  );

  console.log(response.data);
}

deleteProduct(2);
