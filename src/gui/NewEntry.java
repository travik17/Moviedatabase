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
import javax.swing.*;

public class NewEntry extends JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    public ArrayList<Movies> Movies;
    private final JTextField ActorsEditText1 = new JTextField();
    private final JTextField NameEditText1 = new JTextField();
    private final JTextField TimeEditText1 = new JTextField();
    private final JComboBox<String> jComboBox2 = new JComboBox<>();
    private final JLabel NameLabel = new JLabel();
    private final JLabel ActorsLabel1 = new JLabel();
    private final JLabel GenreLabel1 = new JLabel();
    private final JLabel TimeLabel1 = new JLabel();
    private final JLabel ImageLabel1 = new JLabel();
    private final JTextField ImageEditText1 = new JTextField();
    private final JButton SaveEntry1 = new JButton();
    
    /**
     * Creates new form NewEntry
     */
    public NewEntry() {
        initComponents();
    }
                      
    private void initComponents() { 
        setLabels();
        setEditText();

        SaveEntry1.setText("Save");
        SaveEntry1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEntry1ActionPerformed();
            }
        });

        jComboBox2.setModel(new DefaultComboBoxModel<>(genres));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setHorizontal(layout);
        setVertical(layout);
    }    
    
    private void setLabels(){
        NameLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        ActorsLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        GenreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        TimeLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        ImageLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        NameLabel.setText("Name:");      
        ActorsLabel1.setText("Actors:");        
        GenreLabel1.setText("Genre:");        
        TimeLabel1.setText("Time (in min):");        
        ImageLabel1.setText("Image:");
    }
    
    private void setEditText(){
        NameEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
        ActorsEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        TimeEditText1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        ImageEditText1.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    
    private void setHorizontal(GroupLayout layout){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 228, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(NameLabel)
                                .addComponent(ActorsLabel1)
                                .addComponent(GenreLabel1)
                                .addComponent(ImageLabel1)
                                .addComponent(TimeLabel1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(NameEditText1)
                                .addComponent(ActorsEditText1)
                                .addComponent(TimeEditText1)
                                .addComponent(ImageEditText1, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(168, Short.MAX_VALUE)))
        );
    }
    
    private void setVertical(GroupLayout layout){
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(NameLabel)
                        .addComponent(NameEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ActorsLabel1)
                        .addComponent(ActorsEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(GenreLabel1)
                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeLabel1)
                        .addComponent(TimeEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ImageLabel1)
                        .addComponent(ImageEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(69, 69, 69)
                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
    }
    
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
            movie = new Movies(Tabs.MOVIESARRAY.size() - 1, NameEditText1.getText(), Actorlist,
                jComboBox2.getSelectedItem().toString(), Integer.parseInt(TimeEditText1.getText()),  img);
            Tabs.MOVIESARRAY.add(movie);
            Database.addDatabase(movie);
            System.out.println(Tabs.MOVIESARRAY.size());
        } catch (NumberFormatException e){
            System.out.println("User entered a invalid number: " + e.getMessage());
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }                 
}