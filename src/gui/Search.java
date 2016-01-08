package gui;

import autocompleter.Autocomplete;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Search extends JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    
    private final ArrayList<String> keywords = new ArrayList<>();
    private final String COMMIT_ACTION = "commit";
    private final JComboBox<String> GenreSearchCombobox = new JComboBox<>();
    private final JTextField GenreSearchTextField = new JTextField();
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
    public Search() {
        initComponents();
        final DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e){
                //String data = (String) model.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                                
            }
        });
    }
    
    /**
     * Create the autocomplete files for the textfield.
     */
    private void createAutocomplete(){
        //create the keywords file.
        GenreSearchTextField.setFocusTraversalKeysEnabled(false);
        for (int i=0; i<Tabs.MOVIESARRAY.size(); i++){
            Movies movies = Tabs.MOVIESARRAY.get(i);
            for (int j=0; j<movies.Actors.size(); j++){  
                if(!keywords.contains(movies.Actors.get(j))){
                    keywords.add(movies.Actors.get(j));
                }
            }
        }
        
        //initialize class and commit key.
        Autocomplete autoComplete = new Autocomplete(GenreSearchTextField, keywords) {};
        GenreSearchTextField.getDocument().addDocumentListener(autoComplete);
        GenreSearchTextField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        GenreSearchTextField.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
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
        GenreSearchCombobox.setModel(new DefaultComboBoxModel<>(genres));
    }
    
    /**
     * Set the buttons for this view.
     */
    private void setButton(){
        ChangeGenreButton.setText("Search");
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                changeGenreButtonActionPerformed();
            }
        });

        GenreSearchTextField.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        GenreSearchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                genreSearchTextFieldMouseClicked();
            }
        });

        ChangeActorButton.setText("Search");
        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                changeActorButtonActionPerformed();
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
                jTable1MouseClicked();
            }
        });
    }
    
    /**
     * set horizontal layout for jPanel.
     * 
     * @param jPanel1Layout the jPanel layout
     */
    private void setHorizontallayout(GroupLayout jPanel1Layout){
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ActorSearchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GenreSearchTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GenreSearchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenreSearchCombobox, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
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
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(GenreSearchLabel)
                    .addComponent(GenreSearchCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeGenreButton))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ActorSearchLabel)
                    .addComponent(GenreSearchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }
    
    /**
     * Add the movies of the searched genre to the jTable.
     */
    private void changeGenreButtonActionPerformed() {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String genre = (String) GenreSearchCombobox.getSelectedItem();
        for (int i=0; i<Tabs.MOVIESARRAY.size(); i++){
            Movies movies = Tabs.MOVIESARRAY.get(i);
            if(movies.Genre.equalsIgnoreCase(genre)){
                model.addRow(new Object[]{movies.Id, movies.Name, "Actors", movies.Genre,
                    movies.PlayTime, "Image"});
            }
        }
    }                                                 
    
    /**
     * Add the movies of the searched actor to the jTable.
     */
    private void changeActorButtonActionPerformed() {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String actor = GenreSearchTextField.getText();
        for (int i=0; i<Tabs.MOVIESARRAY.size(); i++){
            Movies movies = Tabs.MOVIESARRAY.get(i);
            if (movies.Actors.contains(actor)){
                model.addRow(new Object[]{movies.Id, movies.Name, "Actors", movies.Genre,
                    movies.PlayTime, "Image"});
                } 
        }
    }                                                 
    
    /**
     * Textfield initialize autocomplete.
     */
    private void genreSearchTextFieldMouseClicked() {                                                  
        createAutocomplete();
    }                                                 
    
    /**
     * Actions when the jTable is clicked.
     */
    private void jTable1MouseClicked() {                                     
        int row = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        int column = jTable1.convertColumnIndexToModel(0);
        Integer x = (Integer) jTable1.getModel().getValueAt(row, column);
    }                   
}
