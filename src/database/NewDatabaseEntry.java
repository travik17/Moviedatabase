package database;

import gui.JpaneTabs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import model.Movies;

/**
 * Class for save entry button actions 
 * 
 * @author Mark
 */
public class NewDatabaseEntry {
    
    /**
     * Action when pressing the save button.
     * Add the new movie to the movies array and to the add row.
     * 
     * @param actors
     * @param name
     * @param genre
     * @param time
     */
    public void saveEntry1ActionPerformed(String actors, String name, String genre, Integer time) {                                           
        final ArrayList<String> Actorlist = new ArrayList<>();
        
        Boolean errMessege = testIfempty(name, actors);
        //get the data from the view.
        try{
            if (!errMessege){
                final String[] splitter = actors.split(",");
                Actorlist.addAll(Arrays.asList(splitter));
                Movies movie;
                movie = new Movies(new Object[] {JpaneTabs.MOVIESARRAY.size() - 1, name, Actorlist,
                    genre, time});
                JpaneTabs.MOVIESARRAY.add(movie);
                DatabaseAdd add = new DatabaseAdd();
                add.addDatabase(movie);
            }
        } catch (NumberFormatException e){
            if (!errMessege){
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    } 
    
    /**
     * Test if field is empty
     * 
     * @param name Name of the movie
     * @param actors The actors of the movie
     * @return true if fields are empty
     */
    private boolean testIfempty(String name, String actors){
        if ("".equals(name)){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Name can't be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            if ("".equals(actors)){
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Actors can't be empty", "Warning",
                    JOptionPane.WARNING_MESSAGE);
                return true;
            }
            return false;
        }
    }
}
