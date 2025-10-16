import { useState } from "react"
import MiniGame from "./pages/MiniGame"

export default function App()
{
    const [mGWinStatus, setMGWinStatus] = useState(false);

    const handleChangeMGWinStatus = () => {
        setMGWinStatus(!mGWinStatus);
    }
    return (
        <>
            <h1>Mini Game</h1>

            <MiniGame mGWinStatus={mGWinStatus} 
                      handleChangeMGWinStatus={handleChangeMGWinStatus}
            />
        </>
    )
}