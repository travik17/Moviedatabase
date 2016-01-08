package gui;

import java.awt.Image;
import java.util.ArrayList;

public final class Movies {
    
    protected Integer Id;
    protected String Name;
    protected ArrayList<String> Actors;
    protected String Genre;
    protected Integer PlayTime;
    protected Image Cover;
    
    /**
     * Constructor.
     * 
     * @param id id of the movie.
     * @param name name of the movie.
     * @param actors actors of the movie.
     * @param genre genre of the movie.
     * @param playTime play time of the movie.
     * @param cover cover of the movie.
     */
    public Movies(Integer id, String name, ArrayList<String> actors, String genre, Integer playTime, Image cover){
        setMovieId(id);
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
        this.Id = id;
    }
    
    /**
     * Get the id of the movie.
     * 
     * @return integer with the id of the movie.
     */
    public Integer getMovieId(){
        return Id;
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
    public void setMovieCover(Image cover){
        this.Cover = cover;
    }
    
    /**
     * get cover of the movie
     * 
     * @return image with the cover of the movie
     */
    public Image getMovieCover(){
        return Cover;
    }
    
}
