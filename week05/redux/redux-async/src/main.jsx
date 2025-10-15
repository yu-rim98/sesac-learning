import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";

import router from "./router/index.js";
import { RouterProvider } from "react-router-dom";
import { Provider } from "react-redux";
import { store } from "./store/index.js";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Provider store={store}>
      <RouterProvider router={router} />
    </Provider>
  </StrictMode>
);
