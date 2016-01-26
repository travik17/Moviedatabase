package search;

import database.DatabaseInteraction;
import gui.JpaneTabs;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Movies;

/**
 * Class to create the table and button actions of search
 * 
 * @author Mark
 */
public class SearchTable {
   
    private final JTable table;
    
    public SearchTable(JTable table){
        this.table = table;
    }
    
    /**
     * Set the buttons for this view.
     * 
     * @param ChangeGenreButton The genre button for the actions
     * @param SearchGenCombo The combobox for the actions
     * @param SearchActorText The Text for the actor search
     * @param ChangeActorButton The actor button for the actions
     */
    public void setButton(JButton ChangeGenreButton, final JComboBox SearchGenCombo, final JTextField SearchActorText, JButton ChangeActorButton){
        final SearchInteraction interaction = new SearchInteraction();
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.genreSearch(table, SearchGenCombo);
            }
        });
        SearchActorText.setFont(new Font("Tahoma", 0, 18));
        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.actorSearch(table, SearchActorText);
            }
        });
    }
    
    /**
     * Set the model of jTable.
     */
    public void modelSet(){
        table.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Name", "Actors", "Genre", "Play time", "Cover", "Trailer"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};
            
            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        
        //set the autosorter,
        table.setAutoCreateRowSorter(true);
        table.getRowSorter().toggleSortOrder(1);
        setAlignment();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked();
            }
        });
    }
    
    /**
     * set alignment of the text in the jTable
     */
    private void setAlignment(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i=0;i<7;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
    }
    
    /**
     * Actions when the jTable is clicked.
     */
    private void jTable1MouseClicked() { 
        final int row = table.getSelectedRow();
        final int col = table.getSelectedColumn();
        String idstring = table.getValueAt(row, 0).toString();
        Integer id = Integer.parseInt(idstring);
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        String name = movie.Name;
        DatabaseInteraction interaction = new DatabaseInteraction();
        
        if (col == 5){
            interaction.columnCover(name);
        }
        if (col == 6){
            interaction.columnTrailer(name);
        }
    }
}
