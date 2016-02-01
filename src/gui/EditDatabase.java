package gui;

import java.awt.Font;
import javax.swing.*;
import search.SearchEdit;

/**
 * class for the jpanel for editing the database
 * 
 * @author Mark
 */
public class EditDatabase extends JPanel {

    /**
     * Creates new form NewJPanel
     */
    public EditDatabase() {
        initComponents();
    }
    
    /**
     * Build the view
     */
    private void initComponents() {
        final JTextField searchText = new JTextField();
        final JTextField nameTextfield = new JTextField();
        final JTextField actorTextfield = new JTextField();
        final JTextField timeTextfield = new JTextField();
        JTextField[] fields = {searchText, nameTextfield, actorTextfield, timeTextfield};
        
        searchText.setFont(new Font("Tahoma", 0, 18)); 
        nameTextfield.setFont(new Font("Tahoma", 0, 18));  
        actorTextfield.setFont(new Font("Tahoma", 0, 18)); 
        timeTextfield.setFont(new Font("Tahoma", 0, 18));  

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setlabels();
        editDatbaseButton(fields);
        
        add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 310, -1));
        add(nameTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 580, -1));
        add(actorTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 580, -1));
        add(timeTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 580, -1));
    }
    
    /**
     * add labels to view
     */
    private void setlabels(){
        final JLabel searchLabel = new JLabel("Name of the movie you want to edit");
        final JLabel nameLabel = new JLabel("Name:");
        final JLabel actorsLabel = new JLabel("Actors:");
        final JLabel genreLabel = new JLabel("Genre:");
        final JLabel PlaytimeLabel = new JLabel("    Time:");
        
        searchLabel.setFont(new Font("Tahoma", 0, 18));
        nameLabel.setFont(new Font("Tahoma", 0, 18));
        actorsLabel.setFont(new Font("Tahoma", 0, 18));
        genreLabel.setFont(new Font("Tahoma", 0, 18));
        PlaytimeLabel.setFont(new Font("Tahoma", 0, 18));
        
        add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 340, -1));
        add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));
        add(actorsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 30));
        add(genreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));
        add(PlaytimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 380, 80, 30));
    }
    
    /**
     * Set the buttons and the actions of them
     */
    private void editDatbaseButton(JTextField[] fields){    
        final JComboBox<String> GenreCombo = new JComboBox<>(JpaneTabs.GENRES);
        GenreCombo.setFont(new Font("Tahoma", 0, 18));
        add(GenreCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 580, -1));
        
        final SearchEdit edit = new SearchEdit(fields, GenreCombo);
        JButton searchButton = new JButton("Find movie");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit.searchMovie();
            }
        });
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 90, 30));
        
        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit.saveChanges();
            }
        });
        saveButton.setFont(new Font("Tahoma", 0, 18));
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 150, 40));
    }
}