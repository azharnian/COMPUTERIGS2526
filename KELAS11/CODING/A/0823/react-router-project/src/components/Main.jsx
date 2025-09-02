import { Link, Outlet } from "react-router-dom"

function Nav(){

    return (
        <nav>
            <Link to={''}>Home</Link>
            <Link to={'about'}>About</Link>
            <Link to={'contact'}>Contact</Link>
        </nav>
    )
}

function Header({ children })
{
    return (
        <>
        <header>
            <h2>This is header</h2>
            { children }
        </header>
        </>
    )
}

export default function Main()
{
    return (
        <>
            <Header>
                <Nav />
            </Header>
            
            <Outlet />
        </>
    )
}