package gui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public final class Movies {
    
    public Integer identification;
    public String Name;
    public ArrayList<String> Actors;
    public String Genre;
    public Integer PlayTime;
    public String Cover;
    
    /**
     * Constructor.
     * 
     * @param identification identification of the movie.
     * @param name name of the movie.
     * @param actors actors of the movie.
     * @param genre genre of the movie.
     * @param playTime play time of the movie.
     * @param cover cover of the movie.
     */
    public Movies(Integer identification, String name, ArrayList<String> actors, String genre, Integer playTime, String cover){
        setMovieId(identification);
        setMovieName(name);
        setMovieActors(actors);
        setMovieGenre(genre);
        setMoviePlayTime(playTime);
        setMovieCover(cover);
    }
    
    /**
     * Set the id of movie.
     * 
     * @param id id of the movie.
     */
    public void setMovieId(Integer id){
        this.identification = id;
    }
    
    /**
     * Get the id of the movie.
     * 
     * @return integer with the id of the movie.
     */
    public Integer getMovieId(){
        return identification;
    }
    
    /**
     * Set name of the movie.
     * 
     * @param name name of the movie.
     */
    public void setMovieName(String name){
        this.Name = name;
    }
    
    /**
     * get the name of the movie.
     * 
     * @return string with the name of the movie.
     */
    public String getMovieName(){
        return Name;
    }
    
    /**
     * Set the actors of the movie.
     * 
     * @param actors actors of the movie.
     */
    public void setMovieActors(ArrayList<String> actors){
        this.Actors = actors;
    }
    
    /**
     * Get the actors of the movie.
     * 
     * @return arraylist with the actors of the movie.
     */
    public ArrayList getMovieActors(){
        return Actors;
    }
    
    /**
     * Set the genre of the movie.
     * 
     * @param genre genre of the movie.
     */
    public void setMovieGenre(String genre){
        this.Genre = genre;
    }
    
    /**
     * Get the genre of the movie.
     * 
     * @return string with the genre of the movie.
     */
    public String getMovieGenre(){
        return Genre;
    }
    
    /**
     * Set the play time of the movie.
     * 
     * @param playTime the play time of the movie.
     */
    public void setMoviePlayTime(Integer playTime){
        this.PlayTime = playTime;
    }
    
    /**
     * get the play time of the movie.
     * 
     * @return Integer with the time of the movie.
     */
    public Integer getMoviePlayTime(){
        return PlayTime;
    }
    
    /**
     * set cover of the movie
     * 
     * @param cover the cover of the movie
     */
    public void setMovieCover(String cover){
        this.Cover = cover;
    }
    
    /**
     * get cover of the movie
     * 
     * @return image with the cover of the movie
     */
    public String getMovieCover(){
        return Cover;
    }
    
}
