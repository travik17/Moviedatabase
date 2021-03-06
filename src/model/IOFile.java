package model;

import gui.JpaneTabs;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import static org.apache.commons.lang3.StringUtils.strip;

/**
 * Class to write and read csv files
 * 
 * @author Mark
 */
public class IOFile {
    
    /**
     * write moviearray to .csv file.
     * 
     * @param file the file to write it to.
     */
    public static void createfile(File file){
        try(FileWriter writer = new FileWriter(file)) {              
            for (int i=0; i<JpaneTabs.MOVIESARRAY.size();i++){
                Movies temp = JpaneTabs.MOVIESARRAY.get(i);
                writer.append(temp.getMovieId().toString() + ',');
                writer.append(temp.getMovieName() + ',');
                
                final ArrayList<String> currentActors = temp.getMovieActors();
                for (int j=0; j<currentActors.size();j++){
                    writer.append(currentActors.get(j) + ',');
                }
          
                writer.append(temp.getMovieGenre() + ',');
                writer.append(temp.getMoviePlayTime().toString() + ',');
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e){
             e.getMessage();
        }
    }
    
    /**
     * Read a .csv file
     * 
     * @param file the file to write to.
     */
    public static void readfile(final File file){
        BufferedReader buffer = null;
        String line;
        String SplitBy = ",";
        
        try {
            buffer = new BufferedReader(new FileReader(file));
            while ((line = buffer.readLine()) != null) {
                ArrayList<String> actors = new ArrayList<>();
		String[] splitline = line.split(SplitBy);
                int size = splitline.length;
                int identification = JpaneTabs.MOVIESARRAY.size();
                String name = splitline[1];
                 
                for (int i = 2; i< size - 2; i++){
                    String test = strip(splitline[i]);
                    actors.add(test);
                }

                String genre = splitline[size -2];
                int playTime = Integer.parseInt(splitline[size-1]);

                Movies movie = new Movies(new Object[] {identification,name,actors,genre,playTime});
                JpaneTabs.MOVIESARRAY.add(movie);
            }
	} catch (FileNotFoundException e) {
		JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "File not found", "Warning",
                    JOptionPane.WARNING_MESSAGE);
	} catch (IOException e) {
                System.out.println(e.getMessage());
	} finally {
            if (buffer != null) {
		try {
                    buffer.close();
		} catch (IOException e) {
                    System.out.println("br exception " + e.getMessage());
		}
            }
	}
    }
}