package gui;

import Database.DatabaseAdd;
import Model.Movies;
import java.util.ArrayList;
import java.util.Arrays;
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
    private final JButton SaveEntry1 = new JButton();
    
    /**
     * Constructor.
     */
    public NewEntry() {
        initComponents();
    }
    
    /**
     * Add view components.
     */
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
    
    /**
     * Set the labels of the current view.
     */
    private void setLabels(){
        final String font = "Tahoma";
        NameLabel.setFont(new java.awt.Font(font, 0, 18));
        ActorsLabel1.setFont(new java.awt.Font(font, 0, 18));
        GenreLabel1.setFont(new java.awt.Font(font, 0, 18));
        TimeLabel1.setFont(new java.awt.Font(font, 0, 18));
        
        NameLabel.setText("Name:");      
        ActorsLabel1.setText("Actors:");        
        GenreLabel1.setText("Genre:");        
        TimeLabel1.setText("Time (in min):");        
    }
    
    /**
     * set the TextField of the current view.
     */
    private void setEditText(){
        final String font = "Tahoma";
        NameEditText1.setFont(new java.awt.Font(font, 0, 18));
        ActorsEditText1.setFont(new java.awt.Font(font, 0, 18)); 
        TimeEditText1.setFont(new java.awt.Font(font, 0, 18)); 
    }
    
    /**
     * set Horizontal layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     */
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
                                .addComponent(TimeLabel1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(NameEditText1)
                                .addComponent(ActorsEditText1)
                                .addComponent(TimeEditText1)
                                .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(168, Short.MAX_VALUE)))
        );
    }
    
    /**
     * set Horizontal layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     */
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
                    .addGap(69, 69, 69)
                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
    }
    
    /**
     * Action when pressing the save button.
     * Add the new movie to the movies array and to the add row.
     */
    private void saveEntry1ActionPerformed() {                                           
        final ArrayList<String> Actorlist = new ArrayList<>();

        //get the data from the view.
        try{
            final String Actors = ActorsEditText1.getText();
            final String[] splitter = Actors.split(",");
            Actorlist.addAll(Arrays.asList(splitter));
            Movies movie;
            movie = new Movies(JpaneTabs.MOVIESARRAY.size() - 1, NameEditText1.getText(), Actorlist,
                jComboBox2.getSelectedItem().toString(), Integer.parseInt(TimeEditText1.getText()));
            JpaneTabs.MOVIESARRAY.add(movie);
            DatabaseAdd.addDatabase(movie);
            System.out.println(JpaneTabs.MOVIESARRAY.size());
        } catch (NumberFormatException e){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
        }
    }                 
}