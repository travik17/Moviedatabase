package gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import model.Movies;
import static org.apache.commons.lang3.StringUtils.strip;

/**
 *
 * @author Mark
 */
public class EditDatabase extends JPanel {
    
    private final JButton searchButton = new JButton("Find movie");
    private final JButton saveButton = new JButton("Save Changes");
    private final JComboBox<String> GenreCombo = new JComboBox<>(JpaneTabs.GENRES);
    private final JLabel searchLabel = new JLabel("Name of the movie you want to edit");
    private final JLabel nameLabel = new JLabel("Name:");
    private final JLabel actorsLabel = new JLabel("Actors:");
    private final JLabel genreLabel = new JLabel("Genre:");
    private final JLabel PlaytimeLabel = new JLabel("Play Time:");
    private final JTextField searchText = new JTextField();
    private final JTextField nameTextfield = new JTextField();
    private final JTextField actorTextfield = new JTextField();
    private final JTextField timeTextfield = new JTextField();
    private Integer movieId;
    
    /**
     * Creates new form NewJPanel
     */
    public EditDatabase() {
        initComponents();
    }
                     
    private void initComponents() {
        searchLabel.setFont(new Font("Tahoma", 0, 18)); 
        searchText.setFont(new Font("Tahoma", 0, 18));
        nameLabel.setFont(new Font("Tahoma", 0, 14)); 
        nameTextfield.setFont(new Font("Tahoma", 0, 14)); 
        actorsLabel.setFont(new Font("Tahoma", 0, 14)); 
        actorTextfield.setFont(new Font("Tahoma", 0, 14)); 
        GenreCombo.setFont(new Font("Tahoma", 0, 14)); 
        genreLabel.setFont(new Font("Tahoma", 0, 14)); 
        timeTextfield.setFont(new Font("Tahoma", 0, 14));
        PlaytimeLabel.setFont(new Font("Tahoma", 0, 14));
        saveButton.setFont(new Font("Tahoma", 0, 14));
        
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setHorizontal(layout);
        setVertical(layout);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String name = searchText.getText();
        Boolean found = false;
        for (int i=0; i<JpaneTabs.MOVIESARRAY.size();i++){
            Movies movies = JpaneTabs.MOVIESARRAY.get(i);
            if(name.equalsIgnoreCase(strip(movies.Name))){
                movieId = i;
                setTextfields(movies);
                found = true;
                break;
            }
        }
        if (!found){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No movie with the name: " + name + " found", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    } 
    
    private void setTextfields(Movies movie){
        nameTextfield.setText(movie.Name);
        StringBuilder listofactors = new StringBuilder();
            for (String s : movie.Actors){
                listofactors.append(s);
                listofactors.append(", ");
            }
        GenreCombo.setSelectedItem(movie.Genre);
        actorTextfield.setText(listofactors.toString());
        timeTextfield.setText(movie.PlayTime.toString());
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            String name = nameTextfield.getText();
            String actors = actorTextfield.getText();
            final String[] splitter = actors.split(",");
            ArrayList<String> actorlist = new ArrayList();
            actorlist.addAll(Arrays.asList(splitter));
            Integer time = Integer.parseInt(timeTextfield.getText());
            fieldisEmpty(name, actors);
            Movies movie = JpaneTabs.MOVIESARRAY.get(movieId);
            movie.setMovieName(name);
            movie.setMovieActors(actorlist);
            movie.setMovieGenre(GenreCombo.getSelectedItem().toString());
            movie.setMoviePlayTime(time);
        } catch (NumberFormatException e){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private void fieldisEmpty(String name, String actors){
        if (name.equals("") || actors.equals("")){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No field can be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void setHorizontal(GroupLayout layout){
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(327, 327, 327))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(genreLabel)
                            .addComponent(PlaytimeLabel)
                            .addComponent(actorsLabel)
                            .addComponent(nameLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(actorTextfield, GroupLayout.Alignment.LEADING)
                            .addComponent(GenreCombo, GroupLayout.Alignment.LEADING, 0, 681, Short.MAX_VALUE)
                            .addComponent(timeTextfield, GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextfield))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchText, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchLabel))
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }
    
    private void setVertical(GroupLayout layout){
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(searchLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(actorTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(genreLabel)
                            .addComponent(GenreCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(timeTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlaytimeLabel))
                        .addGap(36, 36, 36)
                        .addComponent(saveButton))
                    .addComponent(actorsLabel))
                .addGap(113, 113, 113))
        );
    }
}