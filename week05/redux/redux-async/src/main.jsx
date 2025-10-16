import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";

import router from "./router/index.js";
import { RouterProvider } from "react-router-dom";
import { Provider } from "react-redux";
import { persistor, store } from "./store/index.js";

// Persist 스토어 적용

import { PersistGate } from "redux-persist/integration/react";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Provider store={store}>
      {/* Persist Gate 적용 */}
      <PersistGate persistor={persistor}>
        <RouterProvider router={router} />
      </PersistGate>
    </Provider>
  </StrictMode>
);
