package gui;

import autocompleter.Autocomplete;
import java.util.ArrayList;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Search extends javax.swing.JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    
    private final ArrayList<String> keywords = new ArrayList<>();
    private final String COMMIT_ACTION = "commit";
    /**
     * Creates new form Search
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
    
    private void createAutocompete(){
        GenreSearchTextField.setFocusTraversalKeysEnabled(false);
        
        for (int i=0; i<Tabs.moviesArray.size(); i++){
            Movies movies = Tabs.moviesArray.get(i);
            for (int j=0; j<movies.Actors.size(); j++){  
                if(!keywords.contains(movies.Actors.get(j))){
                    keywords.add(movies.Actors.get(j));
                }
            }
        }
        
        Autocomplete autoComplete = new Autocomplete(GenreSearchTextField, keywords) {};
        GenreSearchTextField.getDocument().addDocumentListener(autoComplete);
        
        GenreSearchTextField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), COMMIT_ACTION);
        GenreSearchTextField.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel GenreSearchLabel = new javax.swing.JLabel();
        GenreSearchCombobox = new javax.swing.JComboBox<>();
        javax.swing.JButton ChangeGenreButton = new javax.swing.JButton();
        javax.swing.JLabel ActorSearchLabel = new javax.swing.JLabel();
        GenreSearchTextField = new javax.swing.JTextField();
        javax.swing.JButton ChangeActorButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        GenreSearchLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GenreSearchLabel.setText("Search for genre: ");

        GenreSearchCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(genres));

        ChangeGenreButton.setText("Search");
        ChangeGenreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeGenreButtonActionPerformed();
            }
        });

        ActorSearchLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ActorSearchLabel.setText("Search for actor:");

        GenreSearchTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GenreSearchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                genreSearchTextFieldMouseClicked();
            }
        });

        ChangeActorButton.setText("Search");
        ChangeActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActorButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ActorSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GenreSearchTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GenreSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenreSearchCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChangeGenreButton)
                    .addComponent(ChangeActorButton))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenreSearchLabel)
                    .addComponent(GenreSearchCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeGenreButton))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActorSearchLabel)
                    .addComponent(GenreSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeActorButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Actors", "Genre", "Play time", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked();
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void changeGenreButtonActionPerformed() {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String genre = (String) GenreSearchCombobox.getSelectedItem();
        for (int i=0; i<Tabs.moviesArray.size(); i++){
            Movies movies = Tabs.moviesArray.get(i);
            if(movies.Genre.equalsIgnoreCase(genre)){
                model.addRow(new Object[]{movies.Id, movies.Name, "Actors", movies.Genre,
                    movies.PlayTime, "Image"});
            }
        }
    }                                                 

    private void changeActorButtonActionPerformed() {                                                  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String actor = GenreSearchTextField.getText();
        for (int i=0; i<Tabs.moviesArray.size(); i++){
            Movies movies = Tabs.moviesArray.get(i);
            if (movies.Actors.contains(actor)){
                model.addRow(new Object[]{movies.Id, movies.Name, "Actors", movies.Genre,
                    movies.PlayTime, "Image"});
                } 
        }
    }                                                 

    private void genreSearchTextFieldMouseClicked() {                                                  
        createAutocompete();
    }                                                 

    private void jTable1MouseClicked() {                                     
        int row = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        int column = jTable1.convertColumnIndexToModel(0);
        Integer x = (Integer) jTable1.getModel().getValueAt(row, column);
    }    
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GenreSearchCombobox;
    private javax.swing.JTextField GenreSearchTextField;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
