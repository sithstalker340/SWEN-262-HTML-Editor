import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHandler {
	private FileContent mainFileContent;
	
	public FileHandler(){
		
	}
	
	/**
	 * Sends the parameter command to the active file
	 * @param cmd
	 */
	public void pushCommand(Command cmd){
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
	}
	
	/**
	 * Saves the active file
	 */
	public void save(){
		
	}
	
	/**
	 * Prompts the user to save the file with a desired name and location
	 */
	public void saveAs(){
		
	}
	
	/**
	 * Loads a file from the location specified in the parameter
	 * @param loc
	 * @return null
	 */
	public File load(String loc){
		Path path = Paths.get(loc);
		Charset charset = Charset.forName("US-ASCII");
		String allText = "";
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null){
		        System.out.println(line);
		        allText += line;
		    }
		}catch (IOException x){
		    System.err.format("IOException: %s%n", x);
		}
		return new File(allText);

	}
	
	/**
	 * Checks to see if the text in the current file is valid HTML
	 * @return bool
	 */
	public boolean wellFormed(){
		return true;
	}
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		
	}	
}
