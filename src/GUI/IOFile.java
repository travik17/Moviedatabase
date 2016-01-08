package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class IOFile {
    
    public static void Createfile(File file, ArrayList<Movies> movies){
        try(FileWriter writer = new FileWriter(file)) {
                System.out.println(file);
            for (int i=0; i<movies.size();i++){
                Movies temp = movies.get(i);
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
    
    public static void Readfile(String path){
        BufferedReader br = null;
        String line;
        String SplitBy = ",";
        
        try {
		br = new BufferedReader(new FileReader(path));
		while ((line = br.readLine()) != null) {
                        
			String[] splitline = line.split(SplitBy);
                        int size = splitline.length;
                        int id = Integer.parseInt(splitline[0]);
                        String name = splitline[1];
                        ArrayList<String> actors = new ArrayList<>();
                        
                        for (int i = 1; i< size - 3; i++){
                            actors.add(splitline[i]);
                        }

                        String genre = splitline[size -2];
                        int playTime = Integer.parseInt(splitline[size-1]);
                        Movies movie = new Movies(id,name,actors,genre,playTime,null);
                        Tabs.moviesArray.add(movie);
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