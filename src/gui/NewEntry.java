package gui;

import database.DatabaseAdd;
import model.Movies;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class NewEntry extends JPanel {
    
    private final String[] genres = new String[] {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    public ArrayList<Movies> Movies;
    private final JTextField NameEditText1 = new JTextField();
    private final JTextField TimeEditText1 = new JTextField();
    private final JComboBox<String> jComboBox2 = new JComboBox<>();
    private final JLabel NameLabel = new JLabel();
    private final JLabel ActorsLabel1 = new JLabel();
    private final JLabel GenreLabel1 = new JLabel();
    private final JLabel TimeLabel1 = new JLabel();
    private final JButton SaveEntry1 = new JButton();
    private final JTextField ActorsEditText1 = new JTextField();
    
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
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(ActorsEditText1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(389, 389, 389)
                                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(161, 161, 161)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(NameLabel)
                                        .addComponent(ActorsLabel1)
                                        .addComponent(GenreLabel1)
                                        .addComponent(TimeLabel1))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NameEditText1)
                                        .addComponent(jComboBox2, 0, 280, Short.MAX_VALUE)
                                        .addComponent(TimeEditText1))))
                            .addContainerGap(209, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                  
                .addComponent(ActorsEditText1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(NameLabel)
                        .addComponent(NameEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(ActorsLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(GenreLabel1)
                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeLabel1)
                        .addComponent(TimeEditText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(112, 112, 112)
                    .addComponent(SaveEntry1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
        );
    }
    
    /**
     * Action when pressing the save button.
     * Add the new movie to the movies array and to the add row.
     */
    private void saveEntry1ActionPerformed() {                                           
        final ArrayList<String> Actorlist = new ArrayList<>();
        
        Boolean errMessege = testIfempty();
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
            if (!errMessege){
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Please enter a valid number", "Warning",
                JOptionPane.WARNING_MESSAGE);
            }
        }
    } 
    
    private boolean testIfempty(){
        if (NameEditText1.getText().equals("")){
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Name can't be empty", "Warning",
                JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            if (ActorsEditText1.getText().equals("")){
                final JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Actors can't be empty", "Warning",
                    JOptionPane.WARNING_MESSAGE);
                return true;
            }
            return false;
        }
    }
}
