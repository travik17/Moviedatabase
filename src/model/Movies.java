package model;

import java.util.ArrayList;

/**
 * Class to create a movies object
 * 
 * @author Mark
 */
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
     * @param info
     */
    public Movies(Object[] info){
        setMovieId((Integer) info[0]);
        setMovieName((String) info[1]);
        setMovieActors((ArrayList<String>) info[2]);
        setMovieGenre((String) info[3]);
        setMoviePlayTime((Integer) info[4]);
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
}
