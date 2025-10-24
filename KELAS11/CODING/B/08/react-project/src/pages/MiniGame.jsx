import { useState } from "react"
import { getRandomNumber } from "../helper";

export default function MiniGame( { score, handleChangeScore, level } )
{
    const [numberOne, setNumberOne] = useState(getRandomNumber(0, 10, level));
    const [numberTwo, setNumberTwo] = useState(getRandomNumber(0, 10, level));
    const [userAns, setUserAns] = useState("");

    const handleUserAnsChange = (event) => {
        setUserAns(event.target.value);
    }

    const handleFormSubmit = (event) => {
        event.preventDefault();
        
        if (Number(userAns) === numberOne + numberTwo)
        {
            handleChangeScore();
            setUserAns("");
            setNumberOne(getRandomNumber(0, 10, level));
            setNumberTwo(getRandomNumber(0, 10, level));
        }
        return
    }

    return (
        <>
            <h1>Your Score : {score}</h1>
            <h1>Level : {level + 1}</h1>
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