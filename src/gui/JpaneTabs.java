package gui;

import model.Movies;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

/**
 * create add fill the tabbedpanel
 * 
 * @author Mark
 */
public class JpaneTabs extends JFrame {
    
    public final static ArrayList<Movies> MOVIESARRAY = new ArrayList<>();
    public final static String[] GENRES = new String[] {"Action", "Adventure", "Comedy", "Crime", "Drama", "Fantasy", "Historical", "Horror",
        "Mystery", "Philosophical", "Political", "Romance", "Science fiction", "Thriller", "Western", "Animation"};
    
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
        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 550));
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
                JFrame frame = new JpaneTabs();
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
        final JPanel DatabaseTab = new DatabaseUI();
        final JPanel EntryTab = new NewEntry();
        final JPanel SearchTab = new SearchUI();
        final JPanel EditTab = new EditDatabase();
        
        jTabbedPane1.addTab("File Location", LocationTab);        
        jTabbedPane1.addTab("Database", DatabaseTab);        
        jTabbedPane1.addTab("New Entry", EntryTab);       
        jTabbedPane1.addTab("Search", SearchTab);
        jTabbedPane1.addTab("Edit", EditTab);
    }           
}
