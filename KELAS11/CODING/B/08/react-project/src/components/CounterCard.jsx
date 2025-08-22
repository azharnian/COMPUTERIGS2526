import { useState, useEffect } from "react"

export default function CounterCard()
{
  const [counter, setCounter] = useState(10);

//   useEffect(()=>{
//     setCounter(100);
//   }, []);

  const handlePlusBtnClick = () => {
    setCounter(counter + 1);
  }

  const handleMinBtnClick = () => {
    setCounter(counter - 1);
  }

  return (
    <>
      <h1>This is counter {counter}</h1>
      <button onClick={handlePlusBtnClick}>+</button>
      <button onClick={handleMinBtnClick}>-</button>
    </>
  )
}

