package gui;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Database extends JPanel {
    
    public static JTable jTable1;
    /**
     * Constructor.
     */
    public Database() {
        initComponents();  
    }
    
    /**
     * Build scrollpane and add view components.
     */
    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        
        createJtable();
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layoutSet(layout, jScrollPane1);
    }
    
    /**
     * set layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     * @param jScrollPane1 The scrollpane in the layout.
     */
    private void layoutSet(GroupLayout layout, JScrollPane jScrollPane1){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    /**
     * Create a jTable for the database
     */
    private void createJtable(){
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(new Object [][] {}, new String [] {
                "Name", "Actors", "Genre", "Play time", "Image"}) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false, false, false, false};

            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        
        setAlignment();
        setColumnSelect();
    }
    
    /**
     * set alignment of the text in jTable column.
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
     * set jTable autosorter
     */
    private void setColumnSelect(){
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(0);
    }
    
    /**
     * Fill jTable after loading .csv.
     */
    public static void fillDatabase(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Movies> moviesArray = Tabs.MOVIESARRAY;
        for (int i = 0; i<moviesArray.size(); i++){
            Movies temp = moviesArray.get(i);
            //ArrayList<String> actors = temp.Actors;
            
            model.addRow(new Object[]{temp.Name, "Actors", temp.Genre,
                temp.PlayTime, "Image"});
        }    
    }
    
    /**
     * Add a new row to jTable after new entry.
     * 
     * @param temp the movie to add to the jTable.
     */
    public static void addDatabase(Movies temp){
        Object[] row = {temp.Name, "Actors", temp.Genre,
            temp.PlayTime, "Image"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }               
}