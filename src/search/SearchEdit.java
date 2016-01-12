/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import model.Movies;
import gui.JpaneTabs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bas
 */
public class SearchEdit {
    
    private JTable jTable;
        /**
     * Actions when the jTable is clicked.
     * 
     * @param jTable1
     */
    public void jTable1MouseClicked(final JTable jTable1) { 
        jTable = jTable1;
        final int row = jTable.getSelectedRow();
        final int col = jTable.getSelectedColumn();
        
        final DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e){
                String idstring = jTable1.getValueAt(row, 0).toString();
                Integer id = Integer.parseInt(idstring);
                
                switch (col){
                    case 1:
                    case 3:
                        stringsChange(row, col, id);
                        break;
                    case 2:
                        actorChange(row, col, id);
                        break;
                    default:
                        break;
                }              
            }
        });
    }
    
    /**
     * jTable changes in column 1 and 3.
     * 
     * @param row the row selected.
     * @param col the col selected.
     * @param id  the id of the array to change.
     */
    private void stringsChange(int row, int col, Integer id){
        String value = jTable.getValueAt(row, col).toString();
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        if (col == 1){
             movie.setMovieName(value);
        }
        if (col == 3){
            movie.setMovieGenre(value);
        }
        JpaneTabs.MOVIESARRAY.set(id, movie);
    }
    
    /**
     * jTable changes in column 2.
     * 
     * @param row the row selected.
     * @param col the col selected.
     * @param id  the id of the array to change.
     */
    private void actorChange(int row, int col, Integer id){
        ArrayList<String> Actorlist = new ArrayList<>();
        String value = jTable.getValueAt(row, col).toString();
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        String[] splitter = value.split(",");
        Actorlist.addAll(Arrays.asList(splitter));
        movie.setMovieActors(Actorlist);
        JpaneTabs.MOVIESARRAY.set(id, movie);                   
    }
}
