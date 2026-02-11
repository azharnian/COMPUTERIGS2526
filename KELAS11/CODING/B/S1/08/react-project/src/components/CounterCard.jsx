import { useState, useEffect } from "react"

export default function CounterCard(props)
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
      <h1 className="heading-counter-card">This is counter {props.counterFromApp}</h1>
      <div className="container-btn">
          <button onClick={props.handlePlusCounterApp}>+</button>
          <button onClick={props.handleMinCounterApp}>-</button>
      </div>
      
    </>
  )
}

