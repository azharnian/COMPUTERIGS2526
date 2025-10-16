import { useState } from "react"
import { getRandomNumber } from "../helper";

export default function MiniGame( {props} )
{
    const [numberOne, setNumberOne] = useState(getRandomNumber(0, 10));
    const [numberTwo, setNumberTwo] = useState(getRandomNumber(0, 10));
    const [userAns, setUserAns] = useState("");

    const handleUserAnsChange = (event) => {
        setUserAns(event.target.value);
    }

    return (
        <>
            <h1>
                <span>{numberOne}</span> + <span>{numberTwo}</span>
            </h1>
            <form>
                <input type="text" value={userAns} onChange={handleUserAnsChange}/>
                <button>Check Result</button>
            </form>
        </>
    )
}