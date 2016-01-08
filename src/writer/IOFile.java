package writer;

import gui.Movies;
import gui.Tabs;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class IOFile {
    
    /**
     * write moviearray to .csv file.
     * 
     * @param file the file to write it to.
     */
    public static void createfile(File file){
        try(FileWriter writer = new FileWriter(file)) {              
            for (int i=0; i<Tabs.MOVIESARRAY.size();i++){
                Movies temp = Tabs.MOVIESARRAY.get(i);
                writer.append(temp.getMovieId().toString() + ',');
                writer.append(temp.getMovieName() + ',');
                
                ArrayList<String> currentActors = temp.getMovieActors();
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
    public static void readfile(File file){
        BufferedReader br = null;
        String line;
        String SplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
		String[] splitline = line.split(SplitBy);
                int size = splitline.length;
                int id = Tabs.MOVIESARRAY.size();
                String name = splitline[1];
                ArrayList<String> actors = new ArrayList<>();
                        
                for (int i = 1; i< size - 3; i++){
                    actors.add(splitline[i]);
                }

                String genre = splitline[size -2];
                int playTime = Integer.parseInt(splitline[size-1]);
                Movies movie = new Movies(id,name,actors,genre,playTime,null);
                Tabs.MOVIESARRAY.add(movie);
            }
	} catch (FileNotFoundException e) {
		JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "File not found", "Warning",
                    JOptionPane.WARNING_MESSAGE);
	} catch (IOException e) {
                System.out.println(e.getMessage());
	} finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    System.out.println("br exception " + e.getMessage());
		}
            }
	}
    }
}