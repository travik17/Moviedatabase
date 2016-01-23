package search;

import model.Movies;
import autocompleter.Autocomplete;
import gui.JpaneTabs;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class SearchInteraction {

    public void actorSearch(JTable jTable1, JTextField SearchGenText) {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String actor = SearchGenText.getText();
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size(); i++){
            Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            if (movies.Actors.contains(actor)){
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
