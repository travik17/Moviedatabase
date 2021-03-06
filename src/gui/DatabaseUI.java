package gui;

import database.DatabaseInteraction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Class that constructs the GUI of the database tab 
 * 
 * @author Mark
 */
public class DatabaseUI extends JPanel {
    
    public static JTable jTable1;
    /**
     * Constructor.
     */
    public DatabaseUI() {
        initComponents();  
    }
    
    /**
     * Build scrollpane and add view components.
     */
    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        createJtable();
        jScrollPane1.setViewportView(jTable1);
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));
    }
    
    /**
     * Create a jTable for the database
     */
    private void createJtable(){
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(new Object [][] {}, new String [] {
                "Id", "Name", "Actors", "Genre", "Play time", "Image", "trailer"}) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};

            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        setAlignment();
        setColumnSelect();
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                DatabaseInteraction interaction = new DatabaseInteraction();
                interaction.jTable1MouseClicked();}
        });
    }
    
    /**
     * set alignment of the text in jTable column.
     */
    private void setAlignment(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i=0;i<6;i++){
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }

        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);   
    }
    
    /**
     * set jTable autosorter
     */
    private void setColumnSelect(){
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);
    }        
}
