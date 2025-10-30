import { useState, useEffect } from "react"
import { getRandomNumber } from "../helper";

export default function MiniGame( { score, handleChangeScore, level } )
{
    const [numberOne, setNumberOne] = useState(JSON.parse(localStorage.getItem("numberOne")));
    const [numberTwo, setNumberTwo] = useState(JSON.parse(localStorage.getItem("numberTwo")));
    const [userAns, setUserAns] = useState("");

    useEffect(()=>{
        if (!localStorage.getItem("numberOne"))
            localStorage.setItem("numberOne", JSON.stringify(getRandomNumber(0, 10, level)));

        if (!localStorage.getItem("numberTwo"))
            localStorage.setItem("numberTwo", JSON.stringify(getRandomNumber(0, 10, level)));
    }, []);

    const handleUserAnsChange = (event) => {
        setUserAns(event.target.value);
    }

    const handleFormSubmit = (event) => {
        event.preventDefault();
        
        if (Number(userAns) === numberOne + numberTwo)
        {
            handleChangeScore();
            setUserAns("");
            
            const numberOne = getRandomNumber(0, 10, level)
            const numberTwo = getRandomNumber(0, 10, level);

            setNumberOne(numberOne);
            localStorage.setItem("numberOne", JSON.stringify(numberOne));
        
            setNumberTwo(numberTwo);
            localStorage.setItem("numberTwo", JSON.stringify(numberTwo));

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