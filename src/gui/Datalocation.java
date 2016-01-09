package gui;

import writer.FileTypeFilter;
import java.io.File;
import writer.IOFile;
import javax.swing.*;

public class Datalocation extends JPanel {
    
    private String DefaultSLoc = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
    private static final String DefaultLoc = "E:\\torrentz\\test.csv";
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
        LoadLocBut.setText("Load file");
        LoadLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });
        
        //Save button
        SaveLocBut.setText("Save file");
        SaveLocBut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });
    }
    
    private void setGrouplayout(GroupLayout layout){
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(LoadLocBut, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(SaveLocBut, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveLocBut, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadLocBut, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }
    
    private void loadLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser(DefaultLoc);
        choose.setDialogTitle("Open a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));
        
        final int returnval = choose.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            final File file = choose.getSelectedFile();
            IOFile.readfile(file);
            Database.fillDatabase();
        }
    } 
        private void saveLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser(DefaultSLoc);
        choose.setDialogTitle("Save a file");
        choose.setFileFilter(new FileTypeFilter(".csv", "CSV file"));

        int returnval = choose.showSaveDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = choose.getSelectedFile();
            file = new File(file.toString() + ".csv");
            String path = choose.getSelectedFile().getAbsolutePath();
            DefaultSLoc = path;
            IOFile.createfile(file);
        }  
    }                                                                           
}
