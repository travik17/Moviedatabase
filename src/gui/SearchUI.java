package gui;

import search.SearchTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import search.SearchInteraction;

/**
 * Class to create a GUI for search
 * 
 * @author Mark
 */
public class SearchUI extends JPanel {
   
    /**
     * Constructor with tableChanged listener.
     */
    public SearchUI() {
        initComponents();
    }
       
    /**
     * Add view components.
     */
    private void initComponents() {
        final JPanel jPanel1 = new JPanel();
        final JScrollPane jScrollPane1 = new JScrollPane();
        final JTable jTable1 = new JTable();
        
        setGenrebutton(jPanel1, jTable1);
        setActorbutton(jPanel1, jTable1);
        
        SearchTable table = new SearchTable(jTable1);
        table.modelSet();
        
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setPaneComponents(jPanel1);
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 180));
        jScrollPane1.setViewportView(jTable1);
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 750, 310));
    }
    
    /**
     * Set the components in the jpanel
     * 
     * @param jPanel1 the jpanel for the components
     */
    private void setPaneComponents(JPanel jPanel1){
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        final JLabel GenreSearchLabel = new JLabel("Search for genre: ");
        final JLabel ActorSearchLabel = new JLabel("Search for actor: ");
        
        GenreSearchLabel.setFont(new Font("Tahoma", 0, 18));
        ActorSearchLabel.setFont(new Font("Tahoma", 0, 18));
        jPanel1.add(GenreSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 30));
        jPanel1.add(ActorSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1)); 
    }
    
    /**
     * Set the genre button for this view.
     * 
     * @param jPanel1 The panel for the button
     * @param jTable1 The table for the buttons actions
     */
    public void setGenrebutton(JPanel jPanel1, final JTable jTable1){
        final SearchInteraction interaction = new SearchInteraction();
        
        final JComboBox<String> SearchGenCombo = new JComboBox<>(JpaneTabs.GENRES);
        jPanel1.add(SearchGenCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 230, -1));
        
        final JButton ChangeGenreButton = new JButton("Search");
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.genreSearch(jTable1, SearchGenCombo);
            }});
        jPanel1.add(ChangeGenreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 100, 30));
    }
    
    /**
     * Set the actor button for this view.
     * 
     * @param jPanel1 The panel for the button
     * @param jTable1 The table for the buttons actions
     */
    private void setActorbutton(JPanel jPanel1, final JTable jTable1){
        final SearchInteraction interaction = new SearchInteraction();
        
        final JTextField SearchActorText = new JTextField();
        SearchActorText.setFont(new Font("Tahoma", 0, 18));
        jPanel1.add(SearchActorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 230, -1));
        
        final JButton ChangeActorButton = new JButton("Search");
        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.actorSearch(jTable1, SearchActorText);
            }});
        jPanel1.add(ChangeActorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 100, 30));
    }
}
