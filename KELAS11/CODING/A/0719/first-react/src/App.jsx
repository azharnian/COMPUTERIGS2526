import { useState, useEffect } from 'react'
import Home from './components/Home'
import Counter from './components/Counter'
import MiniGames from './components/MiniGames'

import HelloCard from './components/HelloCard'

import PokemonSearch from './components/PokemonSeacrh'

import './App.css'
import DarkModeBtn from './components/DarkModeBtn'

function App() {
  const [isDark, setIsDark] = useState(false);
  const [number, setNumber] = useState(0);

  const handleDarkModeBtn = () => {
    setIsDark(!isDark);
    // console.log(isDark);
  }

  const handleCounter = () =>{
    setNumber(number + 1);
  }

  useEffect(()=>{
    console.log(isDark);
    console.log(number);
  }, []);

  return (
    <>
     
      {/* <HelloCard name="Heru" />
      <HelloCard name="Cindy" />

      <Counter number={number} handleCounter={handleCounter}/>

      <DarkModeBtn isDark={isDark} handleDarkModeBtn={handleDarkModeBtn} /> */}

      <PokemonSearch />
    </>
  )
}

export default App
