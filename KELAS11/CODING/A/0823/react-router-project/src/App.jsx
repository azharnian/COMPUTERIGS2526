import { BrowserRouter, Routes, Route } from "react-router-dom";

import Main from "./components/Main";
import Home from "./components/pages/Home";
import About from "./components/pages/About";

function NoMatch()
{
  return (
    <>
      <h1>Not Found 404!</h1>
    </>
  )
}

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
            <Route element={<Main />}>
                <Route index element={<Home />} />
                <Route path="about" element={<About />} />
                <Route path="*" element={<NoMatch />} />
            </Route>
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App