import React from "react";
import Header from "./components/Header";
import InterPolation from "./components/jsx/InterPolation";
import MyButton from "./components/Component/MyButton";
import MyList from "./components/Component/MyList";

export default function App() {
  return (
    <div>
      {/* <Header />
      <InterPolation /> */}
      <MyList />
      <MyButton />
    </div>
  );
}
