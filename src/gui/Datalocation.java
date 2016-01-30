package gui;

import database.DatabaseAdd;
import model.FileTypeFilter;
import java.io.File;
import model.IOFile;
import javax.swing.*;

/**
 * Class that constructs the GUI of the datalocation tab 
 * 
 * @author Mark
 */
public class Datalocation extends JPanel {

    /**
     * Constructor.
     */
    public Datalocation() {
        initComponents();
    }
    
    /**
     * Add view components and set buttons.
     */
    private void initComponents() {
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());   
        final JButton LoadLocBut = new JButton("Load .csv file");
        LoadLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });
        add(LoadLocBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 180, 90));

        final JButton SaveLocBut = new JButton("Save .csv file");
        SaveLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });
        add(SaveLocBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 180, 90));
    }
    
    /**
     * Shows dialog to choose the file to load
     */
    private void loadLocationButton1ActionPerformed() {  
        String DefaultLoc = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
        JFileChooser choose = new JFileChooser(DefaultLoc);
        choose.setDialogTitle("Open a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));
        
        final int returnval = choose.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            final File file = choose.getSelectedFile();
            IOFile.readfile(file);
            DatabaseAdd add = new DatabaseAdd();
            add.fillDatabase();
        }
    } 
    
    /**
     * Shows dialog to choose folder to save the file
     */
    private void saveLocationButton1ActionPerformed() {
        String DefaultSLoc = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
        JFileChooser choose = new JFileChooser(DefaultSLoc);
        choose.setDialogTitle("Save a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));

        int returnval = choose.showSaveDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = choose.getSelectedFile();
            String path = file.toString();
            file = new File(checkCsv(path));
            IOFile.createfile(file);
        }  
    }
    
    /**
     * check if check already ends with .csv
     * 
     * @param check the entered check
     * @return the correct file check that ends with .csv
     */
    private String checkCsv(String check){
        String name = check;
        if (check.isEmpty() || check.length() < 3){
            return name += ".csv";
        } else {
            String substring = check.substring(check.length() - 4);
            if (substring.equalsIgnoreCase(".csv")){
                return name;
            } else {
                return name += ".csv";
            }  
        }
    }

}
