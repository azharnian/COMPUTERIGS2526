import { useState, useEffect } from "react";

function Loading() {
    return <h1>Now Loading...</h1>;
}

function Result({ pokemon }) {
    if (!pokemon) {
        return <h1>No Pokemon Found</h1>;
    }
    return (
        <>
            <h1>{pokemon?.name}</h1>
            <img src={pokemon?.sprites.front_default} alt="front" />
            <img src={pokemon?.sprites.back_default} alt="back" />
        </>
    );
}

export default function PokemonSearch() {
    const [search, setSearch] = useState("pikachu");
    const [pokemon, setPokemon] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    const handleInput = (event) => {
        setSearch(event.target.value.toLowerCase());
    };

    const handleSubmit = (e) => {
        e.preventDefault();
    };

    useEffect(() => {
        if (search.length < 3) return;

        setIsLoading(true);
        const url = `https://pokeapi.co/api/v2/pokemon/${search}`;
        let timeoutId;

        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Pokemon not found");
                }
                return response.json();
            })
            .then(data => {
                timeoutId = setTimeout(() => {
                    setPokemon(data);
                    setIsLoading(false);
                }, 2000);
            })
            .catch(() => {
                setPokemon(null);
                setIsLoading(false);
            });

        return () => clearTimeout(timeoutId);
    }, [search]);


    return (
        <>
            <form onSubmit={handleSubmit}>
                <input type="text" value={search} onChange={handleInput} />
                <button type="submit">Search</button>
            </form>

            {isLoading ? <Loading /> : <Result pokemon={pokemon} />}
        </>
    );
}
