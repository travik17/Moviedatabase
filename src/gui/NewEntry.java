package gui;

import database.NewDatabaseEntry;
import model.Movies;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to build the new entry gui
 * 
 * @author Mark
 */
public class NewEntry extends JPanel {
    
    public ArrayList<Movies> Movies;
    private final JTextField NameEditText1 = new JTextField();
    private final JTextField TimeEditText1 = new JTextField();
    private final JComboBox<String> jComboBox2 = new JComboBox<>(JpaneTabs.GENRES);
    private final JLabel textLabel = new JLabel("Id, cover and trailer will be automatically generated");
    private final JLabel NameLabel = new JLabel("Name:");
    private final JLabel ActorsLabel1 = new JLabel("Actors");
    private final JLabel ActorsLabel2 = new JLabel ("(separate by ,):");
    private final JLabel GenreLabel1 = new JLabel("Genre:");
    private final JLabel TimeLabel1 = new JLabel("Play time");
    private final JLabel Timelabel2 = new JLabel("(in min): ");
    private final JButton SaveEntry1 = new JButton("Save");
    private final JTextField ActorsEditText1 = new JTextField();
    
    /**
     * Constructor.
     */
    public NewEntry() {
        initComponents();
    }
    
    /**
     * Add view components.
     */
    private void initComponents() { 
        setFont();
        setButton();
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 30));
        add(ActorsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));
        add(SaveEntry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 150, 40));
        add(GenreLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 30));
        add(NameEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 540, -1));
        add(ActorsEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 540, -1));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 540, -1));
        add(TimeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        add(Timelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));
        add(TimeEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 540, -1));
        add(textLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));
        add(ActorsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
    }   
    
    private void setButton(){
        SaveEntry1.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            NewDatabaseEntry entry = new NewDatabaseEntry();
            entry.saveEntry1ActionPerformed(ActorsEditText1, NameEditText1, jComboBox2, TimeEditText1);
        }});
    }
    
    /**
     * Set Fonts for labels and textfield
     */
    private void setFont(){
        java.awt.Font font = new java.awt.Font("Tahoma", 0, 18);
        NameLabel.setFont(font);
        ActorsLabel1.setFont(font);
        GenreLabel1.setFont(font);
        TimeLabel1.setFont(font);
        NameEditText1.setFont(font);
        ActorsEditText1.setFont(font); 
        TimeEditText1.setFont(font);
        textLabel.setFont(font);
        jComboBox2.setFont(font);
        ActorsLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        Timelabel2.setFont(new java.awt.Font("Tahoma", 0, 14));         
    }   
}
