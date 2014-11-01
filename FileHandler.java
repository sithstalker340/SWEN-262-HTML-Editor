
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	private FileContent fileContent;
	private int fileNumbers;
	
	public FileHandler(){
		fileNumbers = 0;
		fileContent = new FileContent();
	}
	
	/**
	 * Sends the parameter command to the active file
	 * @param cmd
	 */
	public void pushCommand(Command cmd){
		fileContent.pushCommand(cmd);
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
		fileContent.popCommand();
	}
	
	public void redoCommand(){
		fileContent.redoCommand();
	}
	
	public boolean canSave(){
		if(fileContent.getActiveFile() == null){
			System.out.println("Unable to save");
			return false;
		}
		
		System.out.println("Able to save");
		return true;
	}
	
	/**
	 * Saves the active file
	 */
	public void save(){
		fileContent.getActiveFile();
		
		FileWriter fw;
		BufferedWriter bw;
		
		try{
			fw = new FileWriter(fileContent.getActiveFile().getPath().toString());
			bw= new BufferedWriter(fw);
			System.out.println("Data to save: " + fileContent.getActiveFile().getBuffer());
			bw.write(fileContent.getActiveFile().getBuffer());
			bw.close();
		}
		
		catch (IOException e1){
			System.out.println("Error saving file '" + fileContent.getActiveFile().getPath().toString() + "'");	
			e1.printStackTrace();
		}
	}
	
	/**
	 * Prompts the user to save the file with a desired name and location
	 */
	public void saveAs(String path){
		
	}
	
	/**
	 * Loads a file from the location specified in the parameter
	 * @param loc
	 * @return null
	 */
	public File load(String loc){
		File newFile;
		String line = "";
		List<String> newBuffer = new ArrayList<String>();
		FileReader fileReader;
		BufferedReader bufferedReader;
		
		try{
			fileReader = new FileReader(loc);
			bufferedReader = new BufferedReader(fileReader);
			newBuffer = new ArrayList<String>();
			
			// stores each line of the file in a list
			while((line = bufferedReader.readLine()) != null) {
	                newBuffer.add(line);
	        	}	
			
			bufferedReader.close();	
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("Unable to open file '" + loc + "'");
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			System.out.println("Error reading file '" + loc + "'");	
			e.printStackTrace();
		}
		
		// used to append the list of lines into a single line
		StringBuilder builder = new StringBuilder();
		for(String s:newBuffer){
			builder.append(s);
			builder.append("\n"); // without new line characters it is a 1 line string
		}
		
		// create the new file and increment unique file ID
		newFile = new File(builder.toString(),fileNumbers);
		newFile.setPath(loc);
		fileNumbers +=1;
		
		fileContent.AddFile(newFile);
		fileContent.changeFile(newFile.getID());
		System.out.println("Active file ID: " + fileContent.getActiveFile().getID());
		return newFile;
	}
	
	/**
	 * Checks to see if the text in the current file is valid HTML
	 * @return boolean
	 */
	public boolean wellFormed(){
		Stack<String> tagStack = new Stack<String>();
		String allText = fileContent.toString(); // the buffer from the file
		
		int start = allText.indexOf('<');
		int end = allText.indexOf('>');
		String tag = "";
		
		if(start == -1 || end == -1){
			if(start == -1 && end == -1){
				return true;
			}
			
			return false;
		}
		
		while(start != -1 && end != -1){
			tag = allText.substring(start + 1, end);
			
			if(tag.indexOf(0) == '/'){
				tag = tag.substring(1);
				
				if(tagStack.peek() == tag){
					tagStack.pop();
				}
				
				else{
					return false;
				}
			}
			
			else{
				int endIndex = allText.indexOf(' ');
				if(endIndex == -1){
					tag = tag.substring(0, endIndex);
				}
				
				if(tag.indexOf(0) != '!'){
					tagStack.push(tag);
				}
			}
			
			allText = allText.substring(end + 1);
			start = allText.indexOf('<');
			end = allText.indexOf('>');
		}
		
		if(tagStack.size() != 0 && checksSelfClose(tag)){
			return false;
		}
		
		return true;
	}
	
	private boolean checksSelfClose(String tag){
		String[] selfClosing = {"meta", "link", "input"};
		
		if(Arrays.asList(selfClosing).indexOf(tag) > -1){
			return true;
		}
		
		return false;
	}
	
	public void updateFileBuffer(String s){
		fileContent.getActiveFile().setBuffer(s);
	}
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		
	}	
}
