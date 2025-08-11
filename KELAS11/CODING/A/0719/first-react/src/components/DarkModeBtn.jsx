
const TextBtn = ( {isDark} ) => {

    return (
        <>
            <span>{ isDark && "🌞" }</span>
            <span style={ {
                fontSize : '20px',
                fontWeight : 'bold',
            } }>{isDark ? "Light" : "Dark"} Button</span>
        </>
    )

}

const DarkModeBtn = ({ isDark, handleDarkModeBtn }) => {

    return (
        <>
            <button style={ {display : 'block'} } onClick={handleDarkModeBtn}> { <TextBtn isDark={isDark} /> } </button>
        </>
    )

}

export default DarkModeBtn;