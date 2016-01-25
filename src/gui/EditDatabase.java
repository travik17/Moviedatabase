package gui;

import java.awt.Font;
import javax.swing.*;
import search.SearchEdit;

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
    
    /**
     * Creates new form NewJPanel
     */
    public EditDatabase() {
        initComponents();
    }
                     
    private void initComponents() {
        JLabel[] labels = {searchLabel, nameLabel, actorsLabel, genreLabel, PlaytimeLabel};
        JTextField[] fields = {searchText, nameTextfield, actorTextfield, timeTextfield};
        SearchEdit edit = new SearchEdit();
        
        saveButton.setFont(new Font("Tahoma", 0, 14));
        edit.editDatbaseButton(searchButton, saveButton);
        edit.editDatbaselabel(labels, fields, GenreCombo);
                
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setHorizontal(layout);
        setVertical(layout);
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