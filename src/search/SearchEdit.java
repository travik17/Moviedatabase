package search;

import database.DatabaseAdd;
import model.Movies;
import gui.JpaneTabs;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static org.apache.commons.lang3.StringUtils.strip;

/**
 * Class for actions on table changes
 * 
 * @author Mark
 */
public class SearchEdit {
    
    private boolean found = false;
    private Integer movieId;
    private JTextField[] fields;
    private JComboBox combo;
    
    public void editDatbaselabel(JLabel[] labels, JTextField[] importfields, JComboBox GenreCombo){
        this.fields = importfields;
        this.combo = GenreCombo;
        String font = "Tahoma";
        labels[0].setFont(new Font(font, 0, 18));
        labels[1].setFont(new Font(font, 0, 14));
        labels[2].setFont(new Font(font, 0, 14));
        labels[3].setFont(new Font(font, 0, 14));
        labels[4].setFont(new Font(font, 0, 14));
        fields[0].setFont(new Font(font, 0, 18)); 
        fields[1].setFont(new Font(font, 0, 14));  
        fields[2].setFont(new Font(font, 0, 14)); 
        fields[3].setFont(new Font(font, 0, 14));
        GenreCombo.setFont(new Font("Tahoma", 0, 14)); 
    }
    
    public void editDatbaseButton(JButton searchButton, JButton saveButton){
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed();
            }
        });
        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed();
            }
        });
    }
    
    private void jButton1ActionPerformed() {                                         
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
    
    private void setTextfields(Movies movie){
        fields[1].setText(movie.Name);
        StringBuilder listofactors = new StringBuilder();
            for (String s : movie.Actors){
                listofactors.append(s);
                listofactors.append(", ");
            }
        combo.setSelectedItem(movie.Genre);
        fields[2].setText(listofactors.toString());
        fields[3].setText(movie.PlayTime.toString());
    }
    
    private void jButton2ActionPerformed() {                                         
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
    
    private void fieldisEmpty(){
        if (fields[1].getText().equals("") || fields[2].getText().equals("")){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No field can be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }
}
