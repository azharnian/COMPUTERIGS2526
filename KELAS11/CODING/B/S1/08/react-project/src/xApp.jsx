import { useState, useEffect } from "react";

import "./App.css";
import CounterCard from "./components/CounterCard";
import OtherCard from "./components/OtherCard";

import MainSection from "./components/MainSection";

function App()
{
  const [name, setName] = useState("Anas");
  const [dark, setDark] = useState(false);

  const [counterFromApp, setCounterFromApp] = useState(0);

  const handlePlusCounterApp = () => {
    setCounterFromApp(counterFromApp + 1);
  }

  const handleMinCounterApp = () => {
    setCounterFromApp(counterFromApp - 1);
  }
  
  useEffect(()=>{
    setName("Budi");
    setDark(true);
  }, []);

  return(
    <div>
        <h1>{ name }</h1>
        <h1>{dark ? "Dark Mode" : "Light Mode"}</h1>
        <h1>{ counterFromApp }</h1>
        <CounterCard  
          counterFromApp={counterFromApp}
          handlePlusCounterApp={handlePlusCounterApp}
          handleMinCounterApp={handleMinCounterApp}
          />
    </div>
  )
}

export default App;