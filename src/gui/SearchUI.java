package gui;

import Search.SearchInteraction;
import Search.SearchEdit;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SearchUI extends JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    
    
    private final JComboBox<String> SearchGenCombo = new JComboBox<>();
    private final JTextField SearchGenText = new JTextField();
    private final JTable jTable1 = new JTable();
    private final JPanel jPanel1 = new JPanel();
    private final JLabel GenreSearchLabel = new JLabel();
    private final JButton ChangeGenreButton = new JButton();
    private final JLabel ActorSearchLabel = new JLabel();
    private final JButton ChangeActorButton = new JButton();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    
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
        setLabels();
        setButton();
        modelSet();
        
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
     * Set the labels for this view.
     */
    private void setLabels(){
        GenreSearchLabel.setFont(new Font("Tahoma", 0, 18));
        ActorSearchLabel.setFont(new Font("Tahoma", 0, 18));
        GenreSearchLabel.setText("Search for genre: ");
        ActorSearchLabel.setText("Search for actor:");
        SearchGenCombo.setModel(new DefaultComboBoxModel<>(genres));
    }
    
    /**
     * Set the buttons for this view.
     */
    private void setButton(){
        final SearchInteraction interaction = new SearchInteraction();
        ChangeGenreButton.setText("Search");
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.GenreSearch(jTable1, SearchGenCombo);
            }
        });

        SearchGenText.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        SearchGenText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                interaction.createAutocomplete(SearchGenText);
            }
        });

        ChangeActorButton.setText("Search");
        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.ActorSearch(jTable1, SearchGenText);
            }
        });
    }
    
    /**
     * Set the model of jTable.
     */
    private void modelSet(){
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Name", "Actors", "Genre", "Play time", "Image"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class};
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        //set the autosorter,
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);
        setAlignment();
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                SearchEdit edit = new SearchEdit();
                edit.jTable1MouseClicked(jTable1);
            }
        });
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
                        .addComponent(SearchGenText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GenreSearchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchGenCombo, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(ChangeGenreButton)
                    .addComponent(ChangeActorButton))
                .addContainerGap(259, Short.MAX_VALUE))
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
                    .addComponent(ChangeGenreButton))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ActorSearchLabel)
                    .addComponent(SearchGenText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeActorButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    /**
     * set alignment of the text in the jTable
     */
    private void setAlignment(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i=0;i<4;i++){
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
    }
}
