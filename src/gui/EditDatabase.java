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
    
    private final JButton searchButton = new JButton("Find movie");
    private final JButton saveButton = new JButton("Save Changes");
    private final JComboBox<String> GenreCombo = new JComboBox<>(JpaneTabs.GENRES);
    private final JLabel searchLabel = new JLabel("Name of the movie you want to edit");
    private final JLabel nameLabel = new JLabel("Name:");
    private final JLabel actorsLabel = new JLabel("Actors:");
    private final JLabel genreLabel = new JLabel("Genre:");
    private final JLabel PlaytimeLabel = new JLabel("    Time:");
    private final JTextField searchText = new JTextField();
    private final JTextField nameTextfield = new JTextField();
    private final JTextField actorTextfield = new JTextField();
    private final JTextField timeTextfield = new JTextField();
    
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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        editDatbaseButton();
        editDatbaselabel();
        
        add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 340, -1));
        add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 310, -1));
        add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));
        add(nameTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 580, -1));
        add(actorsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 30));
        add(actorTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 580, -1));
        add(genreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 30));
        add(GenreCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 580, -1));
        add(PlaytimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 380, 80, 30));
        add(timeTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 580, -1));
    }
    
    /**
     * Set the buttons and the actions of them
     */
    private void editDatbaseButton(){
        JTextField[] fields = {searchText, nameTextfield, actorTextfield, timeTextfield};
        final SearchEdit edit = new SearchEdit(fields, GenreCombo);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit.searchMovie();
            }
        });
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 90, 30));
        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit.saveChanges();
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 150, 40));
    }
    
    /**
     * set the fonts for the components
     */
    private void editDatbaselabel(){
        Font font = new Font("Tahoma", 0, 18);
        searchLabel.setFont(font);
        nameLabel.setFont(font);
        actorsLabel.setFont(font);
        genreLabel.setFont(font);
        PlaytimeLabel.setFont(font);
        searchText.setFont(font); 
        nameTextfield.setFont(font);  
        actorTextfield.setFont(font); 
        timeTextfield.setFont(font);
        saveButton.setFont(font);
        GenreCombo.setFont(font); 
    }
    
}