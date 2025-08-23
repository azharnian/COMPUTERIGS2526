import { useState } from "react"
import Home from "./components/pages/Home"
import About from "./components/pages/About"

function NavBar({ handleChangePage })
{
  const navStyle = {
    display : "inline-block",
    marginRight : "10px"
  }
  return (
    <>
    <nav>
      <a href="" style={navStyle} onClick={handleChangePage}>Home</a>
      <a href="" style={navStyle} onClick={handleChangePage}>About</a>
      <a href="" style={navStyle}>Contact</a>
      <a href="" style={navStyle}>API</a>
      <a href="" style={navStyle}>News</a>
    </nav>
    </>
  )
}

function Footer()
{
  return (
    <>
    <footer>This is footer ... &copy; </footer>
    </>
  )
}

function MainSection({ children })
{
  return (
    <>
      <h1>Hello, React!</h1>
      {children}
    </>
  )
}

function App()
{
  const [page, setPage] = useState("Home");

  const handleChangePage = (e)=>{
    e.preventDefault();
    setPage(e.target.innerHTML);
  }

  return (
    <>
      <MainSection>
        <NavBar handleChangePage={handleChangePage}/>
        {page === "Home" ? <Home/> : <About /> }
        <Footer />
      </MainSection>
    </>
  )
}

export default App;