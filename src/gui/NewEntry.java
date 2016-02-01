package gui;

import database.NewDatabaseEntry;
import javax.swing.*;

/**
 * Class to build the new entry gui
 * 
 * @author Mark
 */
public class NewEntry extends JPanel {
       
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
        final JTextField NameEditText1 = new JTextField();
        final JTextField TimeEditText1 = new JTextField();
        final JComboBox<String> jComboBox2 = new JComboBox<>(JpaneTabs.GENRES);
        final JTextField ActorsEditText1 = new JTextField();
        
        NameEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
        ActorsEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        TimeEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        
        setLabels();
        setButton(ActorsEditText1.getText(), NameEditText1.getText(), jComboBox2.getSelectedItem().toString(), Integer.parseInt(TimeEditText1.getText()));
        
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(NameEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 540, -1));
        add(ActorsEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 540, -1));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 540, -1));
        add(TimeEditText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 540, -1));  
    }   
    
    /**
     * set Label in view
     */
    private void setLabels(){
        final JLabel textLabel = new JLabel("Id, cover and trailer will be automatically generated");
        final JLabel NameLabel = new JLabel("Name:");
        final JLabel ActorsLabel1 = new JLabel("Actors");
        final JLabel ActorsLabel2 = new JLabel ("(separate by ,):");
        final JLabel GenreLabel1 = new JLabel("Genre:");
        final JLabel TimeLabel1 = new JLabel("Play time");
        final JLabel Timelabel2 = new JLabel("(in min): ");
        
        java.awt.Font font = new java.awt.Font("Tahoma", 0, 18);
        NameLabel.setFont(font);
        ActorsLabel1.setFont(font);
        GenreLabel1.setFont(font);
        TimeLabel1.setFont(font);
        textLabel.setFont(font);
        ActorsLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        Timelabel2.setFont(new java.awt.Font("Tahoma", 0, 14));  
        
        add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 30));
        add(ActorsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));
        add(GenreLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 30));
        add(TimeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        add(Timelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));
        add(textLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));
        add(ActorsLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
    }
    
    private void setButton(final String actors, final String name, final String genre, final Integer time){
        final JButton SaveEntry1 = new JButton("Save");
        SaveEntry1.addActionListener(new java.awt.event.ActionListener() {
        @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewDatabaseEntry entry = new NewDatabaseEntry();
                entry.saveEntry1ActionPerformed(actors, name, genre, time);
            }});
        add(SaveEntry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 150, 40));
    }
}
