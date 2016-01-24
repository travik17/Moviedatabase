package search;

import database.DatabaseInteraction;
import model.Movies;
import gui.JpaneTabs;
import javax.swing.JTable;

/**
 * Class for actions on table changes
 * 
 * @author Mark
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
