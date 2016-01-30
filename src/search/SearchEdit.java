package search;

import database.DatabaseAdd;
import model.Movies;
import gui.JpaneTabs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static org.apache.commons.lang3.StringUtils.strip;

/**
 * Class for editing database
 * 
 * @author Mark
 */
public class SearchEdit {
       
    private boolean found = false;
    private Integer movieId;
    private final JTextField[] fields;
    private final JComboBox combo;
    
    /**
     * Constructor
     * 
     * @param texts the textfields for the class
     * @param GenreCombo the combo for the class
     */
    public SearchEdit(JTextField[] texts, JComboBox GenreCombo){
        this.fields = texts;
        this.combo = GenreCombo;
    }
    
    /**
     * Start the search for the movie with the given name
     */
    public void searchMovie() {                                         
        String name = fields[0].getText();
        found = false;
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size();i++){
            Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            if(name.equalsIgnoreCase(strip(movies.Name))){
                movieId = i;
                setTextfields(movies);
                found = true;
                break;
            }
        }
        if (!found){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No movie with the name: " + name + " found", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    } 
    
    /**
     * set the text of the movie in the fields
     * 
     * @param movie The movie to set in the textfields
     */
    private void setTextfields(Movies movie){
        fields[1].setText(strip(movie.Name));
        StringBuilder listofactors = new StringBuilder();
            for (String s : movie.Actors){
                listofactors.append(s);
                listofactors.append(", ");
            }
        combo.setSelectedItem(movie.Genre);
        fields[2].setText(listofactors.toString());
        fields[3].setText(movie.PlayTime.toString());
    }
    
    /**
     * Save the information after changes are made
     */
    public void saveChanges() {                                         
        try{
            String actors = fields[2].getText();
            final String[] splitter = actors.split(",");
            ArrayList<String> actorlist = new ArrayList();
            actorlist.addAll(Arrays.asList(splitter));
            fieldisEmpty();
            Movies movie = new Movies(new Object[]{movieId, fields[1].getText(), actorlist, combo.getSelectedItem().toString(), 
                    Integer.parseInt(fields[3].getText())});
            JpaneTabs.MOVIESARRAY.set(movieId, movie);
            found = false;
            DatabaseAdd add = new DatabaseAdd();
            add.updateDatabase(movie, movieId);
        } catch (NumberFormatException e){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    /**
     * Check if the fields are empty
     */
    private void fieldisEmpty(){
        if (fields[1].getText().equals("") || fields[2].getText().equals("")){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No field can be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }
}
