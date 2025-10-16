function Search({ query, handleChangeQuery }) {
  return (
    <input
      className="search"
      type="text"
      placeholder="Search movies..."
      value={query}
      onChange={handleChangeQuery}
    />
  );
}

export default Search;