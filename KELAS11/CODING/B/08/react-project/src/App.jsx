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
    const [mGWinStatus, setMGWinStatus] = useState(false);
    const [score, setScore] = useState(0);
    const [level, setLevel] = useState(0);

    const handleChangeMGWinStatus = () => {
        setMGWinStatus(mGWinStatus => !mGWinStatus);
    }

    const handleChangeScore = () => {
        setScore(score => score+1);
    }

    const handleChangeLevel = () => {
        setLevel(level => level+1);
    }

    useEffect(()=>{
        if (score % 5 === 0 && score !== 0)
        {
            handleChangeMGWinStatus();
            handleChangeLevel();
        }
            
        return
    }, [score]);

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