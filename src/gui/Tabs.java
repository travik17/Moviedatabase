package gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class Tabs extends JFrame {
    
    public final static ArrayList<Movies> MOVIESARRAY = new ArrayList<>();;
    public static JFrame frame;
    
    public Tabs() {
        initComponents();
    }
                    
    private void initComponents() {
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTabbedPane1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        addTabs(jTabbedPane1);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setGroupLayout(layout, jTabbedPane1);
        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Tabs();
                frame.setVisible(true);
            }
        });
    }
    
    private void addTabs(JTabbedPane jTabbedPane1){
        JPanel LocationTab = new Datalocation();
        JPanel DatabaseTab = new Database();
        JPanel EntryTab = new NewEntry();
        JPanel SearchTab = new Search();
        
        jTabbedPane1.addTab("File Location", LocationTab);        
        jTabbedPane1.addTab("Database", DatabaseTab);        
        jTabbedPane1.addTab("New Entry", EntryTab);       
        jTabbedPane1.addTab("Search", SearchTab);
    }
    
    private void setGroupLayout(GroupLayout layout, JTabbedPane jTabbedPane1){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }                
}
