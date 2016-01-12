/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Movies;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import gui.JpaneTabs;
import static gui.DatabaseUI.jTable1;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DatabaseInteraction {
    
    public void jTable1MouseClicked(){
        final int row = jTable1.getSelectedRow();
        final int col = jTable1.getSelectedColumn();
        String idstring = jTable1.getValueAt(row, 0).toString();
        Integer id = Integer.parseInt(idstring);
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        String name = movie.Name;

        //set standaard images.
        try{
            if (col == 5){
                columnCover(name);
            }
            if(col == 6){
                columnTrailer(name);
            }
        } catch (NullPointerException e){}     
    }
    
    private void columnTrailer(String name){
        TmdbInteraction tmdb = new TmdbInteraction();
        Integer movieId = tmdb.tmdbid(name);
        String trailerPath = tmdb.trailerCreate(movieId);
        
        if (trailerPath == null){
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "No trailer available", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            createSwing(trailerPath);
        }
    }
    
    private void columnCover(String name){
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

    private void createSwing(String trailerPath){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.add(getBrowserPanel(trailerPath));
}

    public static JPanel getBrowserPanel(String trailerPath) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowser.setBarsVisible(false);
        webBrowser.navigate("https://youtu.be/" + trailerPath);
        return webBrowserPanel;
    }
}
