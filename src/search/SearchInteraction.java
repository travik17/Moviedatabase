package search;

import model.Movies;
import model.Autocomplete;
import gui.JpaneTabs;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

/**
 * Class for searches in database
 * 
 * @author Mark
 */
public class SearchInteraction {
    
    /**
     * create the table with movies of given actor
     * 
     * @param jTable1 The table for the rows
     * @param SearchGenText the typed in actor
     */
    public void actorSearch(JTable jTable1, JTextField SearchGenText) {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String actor = SearchGenText.getText();
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size(); i++){
            Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            if (containsCaseInsensitive(actor, movies.Actors)){
                StringBuilder listofactors = new StringBuilder();
                for (String s : movies.Actors){
                    listofactors.append(s);
                    listofactors.append(", ");
                }
                model.addRow(new Object[]{movies.identification, movies.Name, listofactors.toString(), movies.Genre,
                    movies.PlayTime, "Click to see cover", "Click to see trailer"});
            }
        }
    }
    
    /**
     * Ignore the cases in the strings
     * 
     * @param Actor The actor to search
     * @param Actorlist The list of actors
     * @return Return boolean with answer from contains
     */
    private boolean containsCaseInsensitive(String Actor, ArrayList<String> Actorlist){
     for (String string : Actorlist){
        if (containsIgnoreCase(string, Actor)){
            return true;
         }
     }
    return false;
  }
    
    /**
     * create the table with movies of given genre
     * 
     * @param jTable1 The table for the rows
     * @param SearchGenCombo The choosen genre
     */
    public void genreSearch(JTable jTable1, JComboBox SearchGenCombo) {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        final String genre = (String) SearchGenCombo.getSelectedItem();
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size(); i++){
            final Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            if(movies.Genre.equalsIgnoreCase(genre)){
                StringBuilder listofactors = new StringBuilder();
                for (String s : movies.Actors){
                    listofactors.append(s);
                    listofactors.append(", ");
                }
                model.addRow(new Object[]{movies.identification, movies.Name, listofactors.toString(), movies.Genre,
                    movies.PlayTime, "Click to see cover", "Click to see trailer"});
            }
        }
    }
    
    /**
     * Create the autocomplete class and keywordlist for actor textfield
     * 
     * @param SearchGenText the selected textfield
     */
    public void createAutocomplete(JTextField SearchGenText){
        //create the keywords file.
        ArrayList<String> keywords = new ArrayList<>();
        SearchGenText.setFocusTraversalKeysEnabled(false);
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size(); i++){
            
            Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            for (int j=0; j<movies.Actors.size(); j++){
                if(!keywords.contains(movies.Actors.get(j))){
                    keywords.add(movies.Actors.get(j));
                }
            }
        }
        
        //initialize class and commit key.
        Autocomplete autoComplete = new Autocomplete(SearchGenText, keywords) {};
        SearchGenText.getDocument().addDocumentListener(autoComplete);
        SearchGenText.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "commit");
        SearchGenText.getActionMap().put("commit", autoComplete.new CommitAction());
    }
}
