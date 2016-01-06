/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.util.ArrayList;

public class Movies {
    
    protected Integer Id;
    protected String Name;
    protected ArrayList<String> Actors;
    protected String Genre;
    protected Integer PlayTime;
    protected Image Cover;
    
    public Movies(Integer id, String name, ArrayList<String> actors, String genre, Integer playTime, Image cover){
        setMovieId(id);
        setMovieName(name);
        setMovieActors(actors);
        setMovieGenre(genre);
        setMoviePlayTime(playTime);
        setMovieCover(cover);
    }
    
    public void setMovieId(Integer id){
        this.Id = id;
    }
    
    public Integer getMovieId(){
        return Id;
    }
    
    public void setMovieName(String name){
        this.Name = name;
    }
    
    public String getMovieName(){
        return Name;
    }
    
    public void setMovieActors(ArrayList<String> actors){
        this.Actors = actors;
    }
    
    public ArrayList getMovieActors(){
        return Actors;
    }
    
    public void setMovieGenre(String genre){
        this.Genre = genre;
    }
    
    public String getMovieGenre(){
        return Genre;
    }
    
    public void setMoviePlayTime(Integer playTime){
        this.PlayTime = playTime;
    }
    
    public Integer getMoviePlayTime(){
        return PlayTime;
    }
    
    public void setMovieCover(Image cover){
        this.Cover = cover;
    }
    
    public Image getMovieCover(){
        return Cover;
    }
    
}
