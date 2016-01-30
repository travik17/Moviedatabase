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
    
    private final JComboBox<String> SearchGenCombo = new JComboBox<>(JpaneTabs.GENRES);
    private final JTextField SearchActorText = new JTextField();
    private final JTable jTable1 = new JTable();
    private final JLabel GenreSearchLabel = new JLabel("Search for genre: ");
    private final JButton ChangeGenreButton = new JButton("Search");
    private final JLabel ActorSearchLabel = new JLabel("Search for actor: ");
    private final JButton ChangeActorButton = new JButton("Search");
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final JLabel jLabel3 = new JLabel("<html>To edit the database dubble click on <br> the cell. press enter to confirm <br>"
                + "Id, Cover and Trailer can't be edited</html>");
   
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
        
        GenreSearchLabel.setFont(new Font("Tahoma", 0, 18));
        ActorSearchLabel.setFont(new Font("Tahoma", 0, 18));
        jLabel3.setFont(new Font("Tahoma", 0, 14));
        setButton();
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
        jPanel1.add(GenreSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 30));
        jPanel1.add(SearchGenCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 230, -1));
        jPanel1.add(ChangeGenreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 100, 30));
        jPanel1.add(ActorSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));
        jPanel1.add(SearchActorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 230, -1));
        jPanel1.add(ChangeActorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 100, 30));
    }
    
    /**
     * Set the buttons for this view.
     */
    public void setButton(){
        final SearchInteraction interaction = new SearchInteraction();
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.genreSearch(jTable1, SearchGenCombo);
            }
        });
        SearchActorText.setFont(new Font("Tahoma", 0, 18));
        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.actorSearch(jTable1, SearchActorText);
            }
        });
    }
}
