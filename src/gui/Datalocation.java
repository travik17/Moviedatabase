package gui;

import writer.IOFile;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;

public class Datalocation extends javax.swing.JPanel {
    
    private String DefaultSaveLocation = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
    private String DefaultLoadLocation = "E:\\torrentz\\test.csv";
    
    /**
     * Creates new form Datalocation
     */
    public Datalocation() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel SaveLocationLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel LoadLocationLabel1 = new javax.swing.JLabel();
        javax.swing.JButton LoadLocationButton1 = new javax.swing.JButton();
        javax.swing.JButton SaveLocationButton1 = new javax.swing.JButton();
        LoadLocationEditText1 = new javax.swing.JLabel();
        SaveLocationEditText1 = new javax.swing.JLabel();
        javax.swing.JButton SaveButton = new javax.swing.JButton();
        javax.swing.JButton LoadButton = new javax.swing.JButton();

        SaveLocationLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SaveLocationLabel1.setText("Save location:");

        LoadLocationLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LoadLocationLabel1.setText("Load file:");

        LoadLocationButton1.setText("....");
        LoadLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });

        SaveLocationButton1.setText("....");
        SaveLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });

        LoadLocationEditText1.setBorder(LineBorder.createGrayLineBorder());
        LoadLocationEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoadLocationEditText1.setText(DefaultLoadLocation);

        SaveLocationEditText1.setBorder(LineBorder.createGrayLineBorder());
        SaveLocationEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SaveLocationEditText1.setText(DefaultSaveLocation);

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed();
            }
        });

        LoadButton.setText("Load");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadLocationEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoadLocationButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadLocationLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveLocationEditText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveLocationButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(SaveButton)
                .addGap(56, 56, 56)
                .addComponent(LoadButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SaveLocationLabel1)
                    .addContainerGap(654, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveLocationEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(LoadLocationLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoadLocationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadLocationEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(LoadButton))
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(SaveLocationLabel1)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void loadLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser();

        int returnval = choose.showOpenDialog(Datalocation.this);
        if (returnval == JFileChooser.APPROVE_OPTION){
            String path = choose.getSelectedFile().getAbsolutePath();
            LoadLocationEditText1.setText(path);
            DefaultLoadLocation = path;
            System.out.println(DefaultLoadLocation);
        }
    } 
        private void saveLocationButton1ActionPerformed() {                                                    
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnval = choose.showOpenDialog(Datalocation.this);
        if (returnval == JFileChooser.APPROVE_OPTION){
            String path = choose.getSelectedFile().getAbsolutePath();
            SaveLocationEditText1.setText(path);
            DefaultSaveLocation = path;
        }
    }                                                   

    private void saveButtonActionPerformed() {                                           
        IOFile.createfile(DefaultSaveLocation, "test.csv", Tabs.moviesArray);
    }                                          

    private void loadButtonActionPerformed() {                                           
        IOFile.readfile(DefaultLoadLocation);
        Database.FillDatabase();
    }     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoadLocationEditText1;
    private javax.swing.JLabel SaveLocationEditText1;
    // End of variables declaration//GEN-END:variables
}
