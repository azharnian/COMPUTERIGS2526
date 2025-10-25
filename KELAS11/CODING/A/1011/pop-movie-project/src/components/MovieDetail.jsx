export default function MovieDetail({ handleSetNullSelectedMovie }){
    return (
        <>
        <header>
            <button className="btn-back"
                    onClick={handleSetNullSelectedMovie}
            >
              &#x2715;
            </button>
            <img src={null} alt={`${null} poster`} />
            <div className="details-overview">
              <h2>{null}</h2>
              <p>
                <span>📅</span>
                <span>{null}</span>
              </p>
              <p>
                <span>⏳</span>
                <span>{null}</span>
              </p>
              <p>
                <span>🌟</span>
                <span>{null}</span>
              </p>
            </div>
          </header>
          <section>
            <p>
              <em>{null}</em>
            </p>
            <p>Year: {null}</p>
            <p>Genre: {null}</p>
            <p>Starring: {null}</p>
            <p>Directed by: {null}</p>
          </section>
        </>
    )
}