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
        /**
     * Set the buttons for this view.
     * 
     * @param ChangeGenreButton The genre button for the actions
     * @param SearchGenCombo The combobox for the actions
     * @param SearchActorText The Text for the actor search
     * @param ChangeActorButton The actor button for the actions
     * @param table The table for the database add params
     */
    public void setButton(JButton ChangeGenreButton, final JComboBox SearchGenCombo, final JTextField SearchActorText, JButton ChangeActorButton, final JTable table){
        final SearchInteraction interaction = new SearchInteraction();
        ChangeGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.genreSearch(table, SearchGenCombo);
            }
        });
        
        SearchActorText.setFont(new Font("Tahoma", 0, 18));
        SearchActorText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                interaction.createAutocomplete(SearchActorText);
            }
        });

        ChangeActorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                interaction.actorSearch(table, SearchActorText);
            }
        });
    }
    
    /**
     * Set the model of jTable.
     * 
     * @param jTable1 The jtable that is being set
     */
    public void modelSet(final JTable jTable1){
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Name", "Actors", "Genre", "Play time", "Cover", "Trailer"}){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, true, true, true, true, false, false};
            
            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        
        //set the autosorter,
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);
        setAlignment(jTable1);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(jTable1);
            }
        });
    }
    
    /**
     * set alignment of the text in the jTable
     */
    private void setAlignment(JTable jTable1){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i=0;i<7;i++){
            jTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
    }
    
    /**
     * Actions when the jTable is clicked.
     * 
     * @param jTable1
     */
    private void jTable1MouseClicked(final JTable jTable1) { 
        final int row = jTable1.getSelectedRow();
        final int col = jTable1.getSelectedColumn();
        String idstring = jTable1.getValueAt(row, 0).toString();
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
