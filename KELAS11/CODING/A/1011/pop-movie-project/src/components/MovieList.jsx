
function MovieItem({ movie }) {
  return (
    <li key={movie.imdbID}>
      <img  src={movie.Poster} 
            alt={`${movie.Title} poster`} />

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

export default function MovieList({ movies }) {
  return (
    <ul className="list list-movies">
      {movies.map((movie, index) => (

        <MovieItem
          key={index}
          movie={movie}
        />

      ))}
    </ul>
  );
}