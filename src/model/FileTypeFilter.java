package model;

import java.io.File; 
import javax.swing.filechooser.FileFilter; 

/**
 * Class for file to limit the file extentions
 * 
 * @author Mark
 */
public class FileTypeFilter extends FileFilter { 
 
    private final String extension; 
    private final String description; 
  
    /**
     * Constructor.
     * 
     * @param extension the extension for the file type.
     * @param description the discription of the extension.
     */
    public FileTypeFilter(String extension, String description) {
        super();
        this.extension = extension; 
        this.description = description; 
    } 
    
    /**
     * Whether the given file is accepted by this filter.
     * 
     * @param file the file to accept
     * @return the file in lowercase with extension.
     */
    @Override 
    public boolean accept(File file) { 
        if (file.isDirectory()) { 
            return true; 
        } 
        return file.getName().toLowerCase().endsWith(extension); 
    } 
    
    /**
     * The description of this filter.
     * 
     * @return the descriptions
     */
    @Override
    public String getDescription() { 
        return description + String.format(" (*%s)", extension); 
    } 
}
