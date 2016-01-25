package gui;

import search.SearchTable;
import java.awt.Font;
import javax.swing.*;

/**
 * Class to create a GUI for search
 * 
 * @author Mark
 */
public class SearchUI extends JPanel {
    
    private final JComboBox<String> SearchGenCombo = new JComboBox<>(JpaneTabs.GENRES);
    private final JTextField SearchActorText = new JTextField();
    private final JTable jTable1 = new JTable();
    private final JPanel jPanel1 = new JPanel();
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
        // set components.
        GenreSearchLabel.setFont(new Font("Tahoma", 0, 18));
        ActorSearchLabel.setFont(new Font("Tahoma", 0, 18));
        jLabel3.setFont(new Font("Tahoma", 0, 14));
        SearchTable table = new SearchTable(jTable1);
        table.setButton(ChangeGenreButton, SearchGenCombo, SearchActorText, ChangeActorButton);
        table.modelSet();
        
        //set layout of jTable.
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        setHorizontallayout(jPanel1Layout);
        setVerticallayout(jPanel1Layout);
        jScrollPane1.setViewportView(jTable1);
        
        // set layout of panel.
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setGrouplayout(layout);
    }
    

    
    /**
     * set horizontal layout for jPanel.
     * 
     * @param jPanel1Layout the jPanel layout
     */
    private void setHorizontallayout(final GroupLayout jPanel1Layout){
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ActorSearchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchActorText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GenreSearchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchGenCombo, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ChangeGenreButton)
                    .addComponent(ChangeActorButton))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addContainerGap(111, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }
    
    /**
     * set vertical layout of jPanel
     * 
     * @param jPanel1Layout the jPanel layout
     */
    private void setVerticallayout(GroupLayout jPanel1Layout){
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(GenreSearchLabel)
                    .addComponent(SearchGenCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeGenreButton)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ActorSearchLabel)
                    .addComponent(SearchActorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeActorButton)
                    )
                .addContainerGap())
        );
    }
    
    /**
     * set grouplayout
     * 
     * @param layout the layout for parameters
     */
    private void setGrouplayout(GroupLayout layout){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
}
