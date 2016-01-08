package gui;

import writer.IOFile;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Datalocation extends JPanel {
    
    private String DefaultSaveLocation = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";
    private String DefaultLoadLocation = "E:\\torrentz\\test.csv";
    private final JLabel LoadLocationEditText1 = new JLabel();
    private final JLabel SaveLocationEditText1 = new JLabel();
    private final JLabel SaveLocationLabel1 = new JLabel();
    private final JLabel LoadLocationLabel1 = new JLabel();
    private final JButton LoadLocationButton1 = new JButton();
    private final JButton SaveLocationButton1 = new JButton();
    private final JButton SaveButton = new JButton();
    private final JButton LoadButton = new JButton();
    /**
     * Creates new form Datalocation
     */
    public Datalocation() {
        initComponents();
    }
                     
    private void initComponents() {
        setLabels();
        setButtons();
        setEditText();
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setHorizontal(layout);
        setVertical(layout);
    }
    
    private void setLabels(){
        SaveLocationLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        SaveLocationLabel1.setText("Save location:");

        LoadLocationLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        LoadLocationLabel1.setText("Load file:");
    }
    
    private void setButtons() {
        LoadLocationButton1.setText("....");
        LoadLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLocationButton1ActionPerformed();
            }
        });

        SaveLocationButton1.setText("....");
        SaveLocationButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocationButton1ActionPerformed();
            }
        });
        
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed();
            }
        });

        LoadButton.setText("Load");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed();
            }
        });

    }
    
    private void setEditText(){
        LoadLocationEditText1.setBorder(LineBorder.createGrayLineBorder());
        LoadLocationEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
        LoadLocationEditText1.setText(DefaultLoadLocation);

        SaveLocationEditText1.setBorder(LineBorder.createGrayLineBorder());
        SaveLocationEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
        SaveLocationEditText1.setText(DefaultSaveLocation);
    }
    
    private void setHorizontal(GroupLayout layout){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadLocationEditText1, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoadLocationButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoadLocationLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveLocationEditText1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveLocationButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(SaveButton)
                .addGap(56, 56, 56)
                .addComponent(LoadButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SaveLocationLabel1)
                    .addContainerGap(654, Short.MAX_VALUE)))
        );
    }
    
    private void setVertical(GroupLayout layout){
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveLocationEditText1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveLocationButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(LoadLocationLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoadLocationButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadLocationEditText1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(LoadButton))
                .addGap(43, 43, 43))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(SaveLocationLabel1)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );
    }
    
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
        Database.fillDatabase();
    }                         
}
