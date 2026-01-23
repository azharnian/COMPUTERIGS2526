function Header(){

    const titleStyle = {
        color : "red", 
        backgroundColor : "salmon"
    }

    return (
        <>
        <header>
            <div className="logo">
                <h1 style={ titleStyle } >My Company</h1>
            </div>
            <nav>
                <a href="">Home</a>
                <a href="">About</a>
                <a href="">Contact</a>
                <a href="">News</a>
            </nav>
            <button>Login</button>
        </header>
        </>
    )
}

export default Header;