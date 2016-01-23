package database;

import model.Movies;
import gui.JpaneTabs;
import static gui.DatabaseUI.jTable1;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * This is the class that will be called if we want to add something to the database
 * 
 * @author Mark
 */
public class DatabaseAdd {
    /**
     * Fill jTable after loading .csv.
     */
    public static void fillDatabase(){
        final DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        ArrayList<Movies> moviesArray = JpaneTabs.MOVIESARRAY;
        
        //set standaard images.
        for (int i = 0; i<moviesArray.size(); i++){
            Movies temp = moviesArray.get(i);
            StringBuilder listofactors = new StringBuilder();
            for (String s : temp.Actors){
                listofactors.append(s);
                listofactors.append(", ");
            }
            model.addRow(new Object[]{temp.identification, temp.Name, listofactors.toString(), temp.Genre,
                temp.PlayTime, "Click to see cover", "Click to see trailer"});
        }    
    }
    
    /**
     * Add a new row to jTable after new entry.
     * 
     * @param temp the movie to add to the jTable.
     */
    public static void addDatabase(Movies temp){
        StringBuilder listofactors = new StringBuilder();
        for (String s : temp.Actors){
            listofactors.append(s);
            listofactors.append(", ");
        }
        Object[] row = {temp.identification, temp.Name, listofactors.toString(), temp.Genre,
            temp.PlayTime, "Click to see cover", "Click to see trailer"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }  
}
