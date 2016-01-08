package gui;

import writer.FileTypeFilter;
import java.io.File;
import writer.IOFile;
import javax.swing.*;

public class Datalocation extends JPanel {
    
    private String DefaultSaveLocation = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
    private final String DefaultLoadLocation = "E:\\torrentz\\test.csv";
    private final JButton LoadLocationButton1 = new JButton();
    private final JButton SaveLocationButton1 = new JButton();
    /**
     * Creates new form Datalocation
     */
    public Datalocation() {
        initComponents();
    }
                     
    private void initComponents() {
        setButtons();
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setGrouplayout(layout);
    }
    
    private void setButtons() {
        LoadLocationButton1.setText("Load file");
        LoadLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });

        SaveLocationButton1.setText("Save file");
        SaveLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });
    }
    
    private void setGrouplayout(GroupLayout layout){
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(LoadLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(SaveLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }
    
    private void loadLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser(DefaultLoadLocation);
        choose.setDialogTitle("Open a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));
        
        int returnval = choose.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = choose.getSelectedFile();
            IOFile.readfile(file);
            Database.fillDatabase();
        }
    } 
        private void saveLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser(DefaultSaveLocation);
        choose.setDialogTitle("Save a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));

        int returnval = choose.showSaveDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = choose.getSelectedFile();
            file = new File(file.toString() + ".csv");
            String path = choose.getSelectedFile().getAbsolutePath();
            DefaultSaveLocation = path;
            IOFile.createfile(file, Tabs.MOVIESARRAY);
        }  
    }                                                                           
}
