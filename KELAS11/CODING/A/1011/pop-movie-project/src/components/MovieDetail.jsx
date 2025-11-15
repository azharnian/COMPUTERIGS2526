import { useState, useEffect } from "react";
import { fetchMovieDetail } from "../helpers";

export default function MovieDetail({ handleSetNullSelectedMovie, selectedMovie }){
  const [movie, setMovie] = useState({});

  useEffect(() => {
      async function fetchData() {
        try {
          const data = await fetchMovieDetail(selectedMovie);
          setMovie(data);
        } catch(err) {
          console.error(err);
        }
      }

      fetchData();
  }, [selectedMovie]);

  const {
    Title: title,
    Year: year,
    Released: released,
    Poster: poster,
    imdbRating,
    Runtime: runtime,
    Plot: plot,
    Genre: genre,
    Actors: actors,
    Director: director,
  } = movie;

  return (
      <>
      <header>
          <button className="btn-back"
                  onClick={handleSetNullSelectedMovie}
          >
            &#x2715;
          </button>
          <img src={poster} alt={`${title} poster`} />
          <div className="details-overview">
            <h2>{title}</h2>
            <p>
              <span>📅</span>
              <span>{released}</span>
            </p>
            <p>
              <span>⏳</span>
              <span>{runtime}</span>
            </p>
            <p>
              <span>🌟</span>
              <span>{imdbRating}</span>
            </p>
          </div>
        </header>
        <section>
          <p>
            <em>{plot}</em>
          </p>
          <p>Year: {year}</p>
          <p>Genre: {genre}</p>
          <p>Starring: {actors}</p>
          <p>Directed by: {director}</p>
        </section>
      </>
  )
}