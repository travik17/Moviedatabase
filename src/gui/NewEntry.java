/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bas
 */
public class NewEntry extends JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    public ArrayList<Movies> Movies;
    
    /**
     * Creates new form NewEntry
     */
    public NewEntry() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel NameLabel = new javax.swing.JLabel();
        javax.swing.JLabel ActorsLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel GenreLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel TimeLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel ImageLabel1 = new javax.swing.JLabel();
        NameEditText1 = new javax.swing.JTextField();
        ActorsEditText1 = new javax.swing.JTextField();
        TimeEditText1 = new javax.swing.JTextField();
        javax.swing.JTextField ImageEditText1 = new javax.swing.JTextField();
        javax.swing.JButton SaveEntry1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        NameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameLabel.setText("Name:");

        ActorsLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ActorsLabel1.setText("Actors:");

        GenreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GenreLabel1.setText("Genre:");

        TimeLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimeLabel1.setText("Time (in min):");

        ImageLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ImageLabel1.setText("Image:");

        NameEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));

        ActorsEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TimeEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ImageEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SaveEntry1.setText("Save");
        SaveEntry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEntry1ActionPerformed();
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(genres));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(NameLabel)
                                .addComponent(ActorsLabel1)
                                .addComponent(GenreLabel1)
                                .addComponent(ImageLabel1)
                                .addComponent(TimeLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NameEditText1)
                                .addComponent(ActorsEditText1)
                                .addComponent(TimeEditText1)
                                .addComponent(ImageEditText1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(168, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NameLabel)
                        .addComponent(NameEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ActorsLabel1)
                        .addComponent(ActorsEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GenreLabel1)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeLabel1)
                        .addComponent(TimeEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ImageLabel1)
                        .addComponent(ImageEditText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(69, 69, 69)
                    .addComponent(SaveEntry1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void saveEntry1ActionPerformed() {                                           
        ArrayList<String> Actorlist = new ArrayList<>();
        BufferedImage img = null;
        
        
        try {
            img = ImageIO.read(URI.create("http://www.gravatar.com/avatar/d5f91983a9d9cfb69981b6108a63b412?s=32&d=identicon&r=PG").toURL());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try{
            String Actors = ActorsEditText1.getText();
            String[] splitter = Actors.split(",");
            Actorlist.addAll(Arrays.asList(splitter));
            Movies movie;
            movie = new Movies(Tabs.moviesArray.size() - 1, NameEditText1.getText(), Actorlist,
                jComboBox2.getSelectedItem().toString(), Integer.parseInt(TimeEditText1.getText()),  img);
            Tabs.moviesArray.add(movie);
            Database.addDatabase(movie);
            System.out.println(Tabs.moviesArray.size());
        } catch (NumberFormatException e){
            System.out.println("User entered a invalid number: " + e.getMessage());
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActorsEditText1;
    private javax.swing.JTextField NameEditText1;
    private javax.swing.JTextField TimeEditText1;
    private javax.swing.JComboBox<String> jComboBox2;
    // End of variables declaration//GEN-END:variables
}
