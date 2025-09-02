import { useState, useEffect } from "react"
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

const pageToPath = (page) => {
  switch (page) {
    case "Home": return "/";
    case "About": return "/about";
    default: return "/";
  }
};

const pathToPage = (pathname) => {
  if (!pathname || pathname === "/") return "Home";
  if (pathname === "/about") return "About";
};

function App()
{
  const [page, setPage] = useState(() => pathToPage(window.location.pathname));

  const handleChangePage = (e)=>{
    e.preventDefault();
    setPage(e.target.innerHTML);

    const label = e.currentTarget.textContent.trim();
    const url = pageToPath(label);
    window.history.pushState({ page: label }, "", url);
  }

  useEffect(() => {
    const onPop = (e) => {
      const nextPage = e.state?.page ?? pathToPage(window.location.pathname);
      setPage(nextPage);
    };
    window.addEventListener("popstate", onPop);

    if (!window.history.state) {
      window.history.replaceState({ page }, "", pageToPath(page));
    }
    return () => window.removeEventListener("popstate", onPop);
  }, [page]);

  return (
    <>
      <MainSection>
        <NavBar handleChangePage={handleChangePage}/>
        {page === "Home" && <Home/>}
        {page === "About" && <About/>}
        <Footer />
      </MainSection>
    </>
  )
}

export default App;