function MovieItem({ movie, handleOnSelectedMovie }) {
  const fallbackPoster = "https://picsum.photos/200/300?grayscale";

  const handleErrLoadImg = (e) => {
          e.target.onerror = null;
          e.target.src = fallbackPoster;
        }

  const handleClick = () => {
    handleOnSelectedMovie(movie.imdbID);
  }

  return (
    <li key={movie.imdbID} onClick={handleClick}>
      <img
        src={movie?.Poster || fallbackPoster}
        alt={`${movie.Title} poster`}
        onError={handleErrLoadImg}
      />

      <h3>{movie.Title}</h3>

      <div>
        <p>
          <span>📅</span>
          <span>{movie.Year}</span>
        </p>
      </div>
    </li>
  );
}



export default function MovieList({ movies, handleOnSelectedMovie }) {
  return (
    <ul className="list list-movies">
      {movies?.map((movie, index) => (

        <MovieItem
          key={index}
          movie={movie}
          handleOnSelectedMovie={handleOnSelectedMovie}
        />

      ))}
    </ul>
  );
}