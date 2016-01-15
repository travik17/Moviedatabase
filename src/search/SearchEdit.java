package search;

import database.DatabaseInteraction;
import model.Movies;
import gui.JpaneTabs;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

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
        
        final DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e){
                tableChanges(row, col);
            }});
    }
    
    private void tableChanges(int row, int col){
        String idstring = jTable.getValueAt(row, 0).toString();
        Integer id = Integer.parseInt(idstring);
                
        switch (col){
            case 1:
            case 3:
            case 4:
                stringsChange(row, col, id);
                break;
            case 2:
                actorChange(row, col, id);
                break;
            default:
                break;
        }  
    }
    
    /**
     * jTable changes in column 1, 3 and 4.
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
        if (col == 4){
            movie.setMoviePlayTime(Integer.parseInt(value));
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
