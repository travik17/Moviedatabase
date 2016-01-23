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
     * @param ActorsEditText1
     * @param NameEditText1
     * @param jComboBox2
     * @param TimeEditText1 
     */
    public void saveEntry1ActionPerformed(JTextField ActorsEditText1, JTextField NameEditText1, JComboBox jComboBox2, JTextField TimeEditText1) {                                           
        final ArrayList<String> Actorlist = new ArrayList<>();
        
        Boolean errMessege = testIfempty(NameEditText1, ActorsEditText1);
        //get the data from the view.
        try{
            if (!errMessege){
                final String Actors = ActorsEditText1.getText();
                final String[] splitter = Actors.split(",");
                Actorlist.addAll(Arrays.asList(splitter));
                Movies movie;
                movie = new Movies(JpaneTabs.MOVIESARRAY.size() - 1, NameEditText1.getText(), Actorlist,
                    jComboBox2.getSelectedItem().toString(), Integer.parseInt(TimeEditText1.getText()));
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
     * Test for checking empty fields
     * 
     * @param NameEditText1
     * @param ActorsEditText1
     * @return boolean if errormessege has been shown
     */
    private boolean testIfempty(JTextField NameEditText1, JTextField ActorsEditText1){
        if (NameEditText1.getText().equals("")){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Name can't be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            if (ActorsEditText1.getText().equals("")){
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Actors can't be empty", "Warning",
                    JOptionPane.WARNING_MESSAGE);
                return true;
            }
            return false;
        }
    }
}
