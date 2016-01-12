package gui;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class JpaneTabs extends JFrame {
    
    public final static ArrayList<Movies> MOVIESARRAY = new ArrayList<>();;
    public static JFrame frame;
    
    /**
     * Constructor.
     */
    public JpaneTabs() {
        initComponents();
        
    }
    
    /**
     * Add view components.
     */
    private void initComponents() {
        final JTabbedPane jTabbedPane1 = new JTabbedPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jTabbedPane1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        addTabs(jTabbedPane1);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setGroupLayout(layout, jTabbedPane1);
        pack();
    }                       

    /**
     * Main run function.
     * 
     * @param args the command line arguments.
     */
    public static void main(String args[]) {
        NativeInterface.open();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JpaneTabs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JpaneTabs();
                frame.setVisible(true);
            }
        });
        NativeInterface.runEventPump();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }
    
    /**
     * Add the tabs to jTabbedPane.
     * 
     * @param jTabbedPane1 the jTabbedpane to which the tabs are added.
     */
    private void addTabs(final JTabbedPane jTabbedPane1){
        final JPanel LocationTab = new Datalocation();
        final JPanel DatabaseTab = new Database();
        final JPanel EntryTab = new NewEntry();
        final JPanel SearchTab = new Search();
        
        jTabbedPane1.addTab("File Location", LocationTab);        
        jTabbedPane1.addTab("Database", DatabaseTab);        
        jTabbedPane1.addTab("New Entry", EntryTab);       
        jTabbedPane1.addTab("Search", SearchTab);
    }
    /**
     * set grouplayout.
     * 
     * @param layout the layout to add the parameters.
     * @param jTabbedPane1 The jTabbedPane for the layout
     */
    private void setGroupLayout(final GroupLayout layout, JTabbedPane jTabbedPane1){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
    }                
}
