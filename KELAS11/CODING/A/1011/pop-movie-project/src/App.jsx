import { useEffect, useState } from "react";
import NavBar from "./components/NavBar";
import Logo from "./components/Logo";
import Search from "./components/Search";
import NumResults from "./components/NumResults";

import Main from "./components/Main";
import BoxMovies from "./components/BoxMovies";

import { fetchMovie } from "./helpers";

function App()
{
  const [query, setQuery] = useState("oppenheimer");
  const [movies, setMovies] = useState([]);

  const handleChangeQuery = (e) => {
    setQuery(e.target.value);
  }

  useEffect(() => {
    async function fetchData() {
      try {
        const data = await fetchMovie(query);
        setMovies(data);
      } catch(err) {
        console.error(err);
        setMovies([]);
      }      
    } 

    if (query.length < 5) {
      setMovies([]);
      return;
    }

    fetchData();
  }, [query]);

  return (
    <>
    <NavBar>
      <Logo />
      <Search query={query} handleChangeQuery={handleChangeQuery} />
      <NumResults movies={movies} />
    </NavBar>
    <Main>
      <BoxMovies>
           
      </BoxMovies>
      <BoxMovies>
        
      </BoxMovies>
    </Main>
    </>
  )
}

export default App;