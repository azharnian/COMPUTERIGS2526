import { useState } from "react";
import NavBar from "./components/NavBar";
import Logo from "./components/Logo";
import Search from "./components/Search";
import NumResults from "./components/NumResults";

function App()
{
  const [query, setQuery] = useState("oppenheimer");
  const [movies, setMovies] = useState([]);

  const handleChangeQuery = (e) => {
    setQuery(e.target.value);
  }

  return (
    <>
    <NavBar>
      <Logo />
      <Search query={query} handleChangeQuery={handleChangeQuery} />
      <NumResults movies={movies} />
    </NavBar>
    </>
  )
}

export default App;