export default function Counter({number, handleCounter})
{

    return (
        <>
            <h1>{number}</h1>
            <button onClick={handleCounter}>+</button>
            <button>-</button>
        </>
    )
}