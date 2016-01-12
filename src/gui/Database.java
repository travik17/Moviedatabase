package gui;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.Video;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Database extends JPanel {
    
    public static JTable jTable1;
    /**
     * Constructor.
     */
    public Database() {
        initComponents();  
    }
    
    /**
     * Build scrollpane and add view components.
     */
    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        
        createJtable();
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layoutSet(layout, jScrollPane1);
    }
    
    /**
     * set layout parameters for view.
     * 
     * @param layout The layout for which the parameters are.
     * @param jScrollPane1 The scrollpane in the layout.
     */
    private void layoutSet(final GroupLayout layout, JScrollPane jScrollPane1){
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    /**
     * Create a jTable for the database
     */
    private void createJtable(){
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(new Object [][] {}, new String [] {
                "Id", "Name", "Actors", "Genre", "Play time", "Image", "trailer"}) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {false, false, false, false, false, false, false};

            @Override
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        setAlignment();
        setColumnSelect();
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked();
            }
        });
    }
    
    /**
     * set alignment of the text in jTable column.
     */
    private void setAlignment(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }        
    }
    
    /**
     * set jTable autosorter
     */
    private void setColumnSelect(){
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getRowSorter().toggleSortOrder(1);
    }
    
    private void jTable1MouseClicked(){
        final int row = jTable1.getSelectedRow();
        final int col = jTable1.getSelectedColumn();
        String idstring = jTable1.getValueAt(row, 0).toString();
        Integer id = Integer.parseInt(idstring);
        Movies movie = JpaneTabs.MOVIESARRAY.get(id);
        String name = movie.Name;

        
        //set standaard images.
        try{
            if (col == 5){
                Integer movieId = tmdbid(name);
                String path = coverCreate(movieId);
                Image image = null;
                try {
                    image = ImageIO.read(URI.create("https://image.tmdb.org/t/p/w185" + path).toURL());
                } catch (IOException ex) {
                    Logger.getLogger(JpaneTabs.class.getName()).log(Level.SEVERE, null, ex);
                }
                JDialog mydialog = new JDialog();
                mydialog.setSize(200,300);
                mydialog.setTitle("Cover of " + name);
                JLabel label = new JLabel("", new ImageIcon(image), JLabel.CENTER);
                mydialog.add(label, BorderLayout.CENTER);
                mydialog.setVisible(true);
            }
            if(col == 6){
               Integer movieId = tmdbid(name);
               String trailerPath = trailerCreate(movieId);
               if (trailerPath == null){
                   JPanel panel = new JPanel();
                   JOptionPane.showMessageDialog(panel, "No trailer available", "Warning",
                    JOptionPane.WARNING_MESSAGE);
               } else {
                   createSwing(trailerPath);
               }
            }
        } catch (NullPointerException e){}     
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

    
    private Integer tmdbid(String name){
        TmdbSearch search = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getSearch();
        MovieResultsPage result = search.searchMovie(name, 0, null, false, 0);
        List<MovieDb> list = result.getResults();
        MovieDb dbmovie = list.get(0);
        Integer i = dbmovie.getId();
        return i ;
    }
    
    private String trailerCreate(Integer i){
        TmdbMovies movies = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getMovies();
        List<Video> videos = movies.getVideos(i, "nl");
        String key;
        if (videos.isEmpty()){
            key = null;
        } else {
            Video video = videos.get(0);
            key = video.getKey();
        }
        return key;
    }
    
    private String coverCreate(Integer i){
        TmdbMovies movies = new TmdbApi("0d11e0bc8db3815dc4cb914cba6e304d").getMovies();
        MovieImages imagetest = movies.getImages(i, null);
        List<Artwork> test = imagetest.getPosters();
        Artwork art = test.get(0);
        String x = art.getFilePath();
        return x;
    }
    
    /**
     * Fill jTable after loading .csv.
     */
    public static void fillDatabase(){
        final DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        ArrayList<Movies> moviesArray = JpaneTabs.MOVIESARRAY;
        
        BufferedImage img = null;
        //set standaard images.
        for (int i = 0; i<moviesArray.size(); i++){
            Movies temp = moviesArray.get(i);
            StringBuilder listofactors = new StringBuilder();
            for (String s : temp.Actors){
                listofactors.append(s);
                listofactors.append(", ");
            }
            model.addRow(new Object[]{temp.identification, temp.Name, listofactors.toString(), temp.Genre,
                temp.PlayTime, "Click to see cover", "Click to see trailer"});
        }    
    }
    
    /**
     * Add a new row to jTable after new entry.
     * 
     * @param temp the movie to add to the jTable.
     */
    public static void addDatabase(Movies temp){
        StringBuilder listofactors = new StringBuilder();
        for (String s : temp.Actors){
            listofactors.append(s);
            listofactors.append(", ");
        }
        Object[] row = {temp.identification, temp.Name, listofactors.toString(), temp.Genre,
            temp.PlayTime, "Click to see cover", "Click to see trailer"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }               
}
