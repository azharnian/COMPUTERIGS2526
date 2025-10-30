import { useState, useEffect } from "react"
import MiniGame from "./pages/MiniGame"

function WinPage({ handleChangeMGWinStatus })
{
    return (
        <>
            <h1>You Win!</h1>
            <button onClick={handleChangeMGWinStatus}>Play Again</button>
        </>
    )
}

export default function App()
{
    const [mGWinStatus, setMGWinStatus] = useState(JSON.parse(localStorage.getItem("mGWinStatus")));
    const [score, setScore] = useState(JSON.parse(localStorage.getItem("score")));
    const [level, setLevel] = useState(JSON.parse(localStorage.getItem("level")));

    const handleChangeMGWinStatus = () => {
        setMGWinStatus(mGWinStatus => !mGWinStatus);
    }

    const handleChangeScore = () => {
        setScore(score => score+1);
        localStorage.setItem("score", JSON.stringify(score+1));

        if (score % 5 === 0 && score !== 0 && !mGWinStatus)
        {
            handleChangeMGWinStatus();
            handleChangeLevel();
            handleChangeMGWinStatus();
        }
    }

    const handleChangeLevel = () => {
        setLevel(level => level+1);
        localStorage.setItem("level", JSON.stringify(level+1));
    }

    useEffect(()=>{
        if (!localStorage.getItem("mGWinStatus"))
            localStorage.setItem("mGWinStatus", JSON.stringify(false));

        if (!localStorage.getItem("score"))
            localStorage.setItem("score", JSON.stringify(0));
        
        if (!localStorage.getItem("level"))
            localStorage.setItem("level", JSON.stringify(0));

        // const score = JSON.parse(localStorage.getItem("score"));
        // const level = JSON.parse(localStorage.getItem("level"));

        // console.log(score, level);
    }, []);

    return (
        <>
            <h1>Mini Game</h1>
            {
            mGWinStatus ? <WinPage 
                    handleChangeMGWinStatus={handleChangeMGWinStatus} 
                /> : 
            
            <MiniGame 
                score={score}
                handleChangeScore={handleChangeScore}
                level={level}

            />
            }
            
        </>
    )
}