import { OMDB_API_KEY } from "../config";

export async function fetchMovie(query) {
    try {
        const res = await fetch(
            `https://www.omdbapi.com/?s=${query}&apikey=${OMDB_API_KEY}`
        );
        const data = await res.json();
        return data;
    } catch (err) {
        return err;
    } 
}

export async function fetchMovieDetail(selectedId) {
    try {
        const res = await fetch(
            `https://www.omdbapi.com/?apikey=${OMDB_API_KEY}&i=${selectedId}`
        );
        const data = await res.json();
        return data;
    } catch (err) {

    }
}