package database;

import model.Movies;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import gui.JpaneTabs;
import static gui.DatabaseUI.jTable1;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class for actions with the database table
 * 
 * @author Mark
 */
public class DatabaseInteraction {
    
    /**
     * Get id and name from the row that was clicked then on column determine action
     */
    public void jTable1MouseClicked(){
        final int row = jTable1.getSelectedRow();
        final int col = jTable1.getSelectedColumn();
        String idstring = jTable1.getValueAt(row, 0).toString();
        Integer id = Integer.parseInt(idstring);
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        String name = movie.Name;

        //set standaard images.
        if (col == 5){
            columnCover(name);
        }
        if (col == 6){
            columnTrailer(name);
        } 
    }
    
    /**
     * Create trailer swing if there is a trailer. If not show warning message
     * 
     * @param name The name of the movie
     */
    public void columnTrailer(String name){
        TmdbInteraction tmdb = new TmdbInteraction();
        Integer movieId = tmdb.tmdbid(name);
        String trailerPath = tmdb.trailerCreate(movieId);
        
        if ("empty".equals(trailerPath)){
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No trailer available", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            createSwing(trailerPath);
        }
    }
    
    /**
     * Create panel with cover if possible
     * 
     * @param name The name of the movie
     */
    public void columnCover(String name){
        TmdbInteraction tmdb = new TmdbInteraction();
        Integer movieId = tmdb.tmdbid(name);
        String path = tmdb.coverCreate(movieId);
        Image image = null;
        
        try {
            image = ImageIO.read(URI.create("https://image.tmdb.org/t/p/w185" + path).toURL());
        } catch (IOException ex) {
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No cover available", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        JDialog mydialog = new JDialog();
        mydialog.setSize(200,300);
        mydialog.setTitle("Cover of " + name);
        JLabel label = new JLabel("", new ImageIcon(image), JLabel.CENTER);
        mydialog.add(label, BorderLayout.CENTER);
        mydialog.setVisible(true);
    }
    
    /**
     * Create new frame for browserpanel
     * 
     * @param trailerPath The path of the trailer
     */
    private void createSwing(String trailerPath){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.add(getBrowserPanel(trailerPath));
}
    
    /**
     * Returns browser panel for the trailer swing
     * 
     * @param trailerPath The path of the trailer
     * @return The web panel to the trailer adress
     */
    public static JPanel getBrowserPanel(String trailerPath) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowser.setBarsVisible(false);
        webBrowser.navigate("https://youtu.be/" + trailerPath);
        return webBrowserPanel;
    }
}
