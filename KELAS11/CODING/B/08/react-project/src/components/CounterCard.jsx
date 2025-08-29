import { useState, useEffect } from "react"

export default function CounterCard()
{
  const [counter, setCounter] = useState(10);

  const handlePlusBtnClick = () => {
    setCounter(counter + 1);
  }

  const handleMinBtnClick = () => {
    setCounter(counter - 1);
  }

  return (
    <>
      <h1 className="heading-counter-card">This is counter {counter}</h1>
      <div className="container-btn">
          <button onClick={handlePlusBtnClick}>+</button>
          <button onClick={handleMinBtnClick}>-</button>
      </div>
      
    </>
  )
}

