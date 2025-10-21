import { useState, useEffect } from "react"
import { getRandomNumber } from "../helper";

export default function MiniGame( { mGWinStatus, handleChangeMGWinStatus } )
{
    const [numberOne, setNumberOne] = useState(getRandomNumber(0, 10));
    const [numberTwo, setNumberTwo] = useState(getRandomNumber(0, 10));
    const [userAns, setUserAns] = useState("");
    const [score, setScore] = useState(0);

    const handleUserAnsChange = (event) => {
        setUserAns(event.target.value);
    }

    const handleFormSubmit = (event) => {
        event.preventDefault();
        
        if (Number(userAns) === numberOne + numberTwo)
        {
            if (score <= 5){
                setScore(score+1);
                setUserAns("");
                setNumberOne(getRandomNumber(0, 10));
                setNumberTwo(getRandomNumber(0, 10));
            }
        }
        return
    }

    useEffect(()=>{
        if (score == 5)
            handleChangeMGWinStatus();
        return
    }, [score]);

    return (
        <>
            <h1>Your Score : {score}</h1>
            <h1>
                <span>{numberOne}</span> + <span>{numberTwo}</span>
            </h1>
            <form onSubmit={handleFormSubmit}>
                <input type="text" value={userAns} onChange={handleUserAnsChange}/>
                <button>Check Result</button>
            </form>
        </>
    )
}