import { useState } from "react";

export default function BoxMovies({ children }) {
  const [isOpen, setIsOpen] = useState(true);

  const handleClickBtn = () => {
    setIsOpen(isopen => !isopen)
  }

  return (
    <div className="box">
      <button   className="btn-toggle" 
                onClick={handleClickBtn}>
        {isOpen ? "-" : "+"}
      </button>
      {isOpen && children}
    </div>
  );
}