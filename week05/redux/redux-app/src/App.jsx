import React from "react";
import Counter from "./components/Counter";
import CounterIncrement from "./components/CounterIncrement";
import CounterIncrementByAmount from "./components/CounterIncrementByAmount";
import CounterReset from "./components/CounterReset";

const App = () => {
  return (
    <div>
      <Counter />
      <CounterIncrement />
      <CounterIncrementByAmount />
      <CounterReset />
    </div>
  );
};

export default App;
