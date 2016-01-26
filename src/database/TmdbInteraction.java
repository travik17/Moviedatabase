package database;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.util.List;

/**
 *  This class handeles the intaction with the tmdb database
 * 
 * @author Mark
 */
public class TmdbInteraction {
    
    /**
     * Returns the id used bij tmdb
     * 
     * @param name The name of the movie
     * @return The id of the movie with param name
     */
    public Integer tmdbid(String name){
        TmdbSearch search = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getSearch();
        MovieResultsPage result = search.searchMovie(name, 0, null, false, 0);
        List<MovieDb> list = result.getResults();
        MovieDb dbmovie = list.get(0);
        Integer i = dbmovie.getId();
        return i ;
    }
    
    /**
     * Returns the path of the cover image
     * 
     * @param i The tmdb id of a movie
     * @return String with the path to the cover of the request movie
     */
    public String coverCreate(Integer i){
        TmdbMovies movies = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getMovies();
        MovieImages imagetest = movies.getImages(i, null);
        List<Artwork> test = imagetest.getPosters();
        Artwork art = test.get(0);
        String x = art.getFilePath();
        return x;
    }
    
    /**
     * Returns the path to the trailer of the movie
     * 
     * @param i The tmdb id of a movie
     * @return String with the path to the trailer of the request movie or null if it does not exists
     */
    public String trailerCreate(Integer i){
        TmdbMovies movies = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getMovies();
        List<Video> videos = movies.getVideos(i, "nl");
        String key;
        if (videos.isEmpty()){
            key = "empty";
        } else {
            Video video = videos.get(0);
            key = video.getKey();
        }
        return key;
    }
    
}
