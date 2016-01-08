package gui;

import writer.IOFile;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Database extends javax.swing.JPanel {
    
    public static javax.swing.JTable jTable1;
    /**
     * Creates new form Database
     */
    public Database() {
        initComponents();
        IOFile.readfile("E:\\torrentz\\test.csv");
        Database.fillDatabase();
      
    }
    
    private void initComponents() {
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        
        createJtable();
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layoutSet(layout, jScrollPane1);
    }
    
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
    
    private void setAlignment(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
    }
    
    private void setColumnSelect(){
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(0);
    }
    
    public static void fillDatabase(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Movies> moviesArray = Tabs.moviesArray;
        for (int i = 0; i<moviesArray.size(); i++){
            Movies temp = moviesArray.get(i);
            //ArrayList<String> actors = temp.Actors;
            
            model.addRow(new Object[]{temp.Name, "Actors", temp.Genre,
                temp.PlayTime, "Image"});
        }    
    }
    
    public static void addDatabase(Movies temp){
        Object[] row = {temp.Name, "Actors", temp.Genre,
            temp.PlayTime, "Image"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }               
}