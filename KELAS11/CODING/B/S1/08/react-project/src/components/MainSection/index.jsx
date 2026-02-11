import "./main-section.css"

function MainSection()
{
    const pStyle = {
        fontFamily : "arial",
        fontSize : "50px"
    };

    return (
        <>
            <section>
                <h1 style={ {color : "red"} }>Hello, Main Section</h1>
                <p style={ pStyle }>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati quisquam dignissimos reprehenderit! Quisquam ad cupiditate consectetur ab porro velit sunt!
                </p>
                <p className="formatted-text">
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Aliquid dicta eveniet neque corrupti odit. Nam reiciendis distinctio, veritatis eos molestiae atque! Dolorem ipsa explicabo eveniet nihil est? Voluptate, in repudiandae.
                </p>
            </section>
        </>
    )
}

export default MainSection;