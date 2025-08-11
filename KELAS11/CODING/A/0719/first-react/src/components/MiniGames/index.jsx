import { useState } from "react";
import "./mini-games.css";

function MiniGames()
{
    const [num1, setNum1] = useState(10);
    const [num2, setNum2] = useState(20);
    const [ans, setAns] = useState("");

    function handleSubmit(e)
    {
        e.preventDefault();
        if (num1 + num2 == parseInt(ans))
        {
            alert("Correct!")
        } else
        {
            alert("Incorrect!");
        }
    }

    const formStyle = {
        width : "300px",
        height : "500px",
        backgroundColor : "yellowgreen",
        margin : "0 auto",
    }
    
    return (
        <>
            <form onSubmit={handleSubmit} style={formStyle}>
                <h1 style={ {color:"salmon", textAlign:"center"} }><span>{num1}</span> + <span>{num2}</span></h1>
                <input className="game" type="text" value={ans} onChange={(e)=> setAns(e.target.value)} />
                <button className="game">Check</button>
            </form>
        </>
    )
}

export default MiniGames;