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
    
    private final JButton LoadLocBut = new JButton();
    private final JButton SaveLocBut = new JButton();
    
    /**
     * Constructor.
     */
    public Datalocation() {
        initComponents();
    }
    
    /**
     * Add view components.
     */
    private void initComponents() {
        setButtons();
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setGrouplayout(layout);
    }
    
    /**
     * Set text and actionlisteners of buttons in view.
     */
    private void setButtons() {
        //Load button
        LoadLocBut.setText("Load .csv file");
        LoadLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });
        
        //Save button
        SaveLocBut.setText("Save .csv file");
        SaveLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });
    }
    
    /**
     * Set the layout of the panel
     * 
     * @param layout The layout to which the params are added
     */
    private void setGrouplayout(GroupLayout layout){
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(LoadLocBut, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(SaveLocBut, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveLocBut, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadLocBut, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
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
