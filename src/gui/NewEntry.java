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
    private final JLabel NameLabel = new JLabel("Name:");
    private final JLabel ActorsLabel1 = new JLabel("Actors:");
    private final JLabel GenreLabel1 = new JLabel("Genre:");
    private final JLabel TimeLabel1 = new JLabel("Time (in min):");
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
        SaveEntry1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewDatabaseEntry entry = new NewDatabaseEntry();
                entry.saveEntry1ActionPerformed(ActorsEditText1, NameEditText1, jComboBox2, TimeEditText1);
            }});
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setHorizontal(layout);
        setVertical(layout);
    }    
    
    /**
     * Set Fonts for labels and textfield
     */
    private void setFont(){
        final String font = "Tahoma";
        NameLabel.setFont(new java.awt.Font(font, 0, 18));
        ActorsLabel1.setFont(new java.awt.Font(font, 0, 18));
        GenreLabel1.setFont(new java.awt.Font(font, 0, 18));
        TimeLabel1.setFont(new java.awt.Font(font, 0, 18));
        NameEditText1.setFont(new java.awt.Font(font, 0, 18));
        ActorsEditText1.setFont(new java.awt.Font(font, 0, 18)); 
        TimeEditText1.setFont(new java.awt.Font(font, 0, 18));         
    }
    
    /**
     * set Horizontal layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     */
    private void setHorizontal(GroupLayout layout){
        layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(ActorsEditText1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(389, 389, 389)
                                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(161, 161, 161)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(NameLabel)
                                        .addComponent(ActorsLabel1)
                                        .addComponent(GenreLabel1)
                                        .addComponent(TimeLabel1))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NameEditText1)
                                        .addComponent(jComboBox2, 0, 280, Short.MAX_VALUE)
                                        .addComponent(TimeEditText1))))
                            .addContainerGap(209, Short.MAX_VALUE))));
    }
    
    /**
     * set Horizontal layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     */
    private void setVertical(GroupLayout layout){
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)   
                .addComponent(ActorsEditText1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(NameLabel)
                        .addComponent(NameEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(ActorsLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(GenreLabel1)
                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeLabel1)
                        .addComponent(TimeEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(112, 112, 112)
                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE))));
    } 
}
