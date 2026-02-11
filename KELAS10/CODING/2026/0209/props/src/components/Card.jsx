
const cardStyle = {
    display : "inline-block",
    margin : "0px 10px",
    border : "1px black solid",
    height : "50px",
    width : "100px",
    backgroundColor : "yellowgreen",
    textAlign : "center",
    lineHeight : "50px",
}

export default function Card({number}){

    return (
        <div style={cardStyle}>
            <h1>{number}</h1>
        </div>
    )
}