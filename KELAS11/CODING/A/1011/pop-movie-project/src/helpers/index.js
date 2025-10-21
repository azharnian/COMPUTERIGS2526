import { OMDB_API_KEY } from "../config";

export async function fetchMovie(query) {
    try {
        const res = await fetch(
            `http://www.omdbapi.com/?s=${query}&apikey=${OMDB_API_KEY}`
        );
        const data = await res.json();
        // console.log(data.Search);
        return data;
    } catch (err) {
        // console.log(err);
        return err;
    } 
}