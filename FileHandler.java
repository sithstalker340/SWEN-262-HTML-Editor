
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

import javafx.stage.FileChooser;

import javax.swing.JFileChooser;

public class FileHandler {
	private FileContent fileContent;
	private int fileNumbers;
	private Mediator mediator;
	
	public FileHandler(Mediator med){
		fileNumbers = 0;
		fileContent = new FileContent();
		mediator = med;
	}
	
	/**
	 * Sends the parameter command to the active file
	 * @param cmd
	 */
	public void pushCommand(Command cmd){
		fileContent.pushCommand(cmd);
		updateDisplay();
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
		fileContent.popCommand();
		updateDisplay();
	}
	
	public void redoCommand(){
		fileContent.redoCommand();
		updateDisplay();
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
	public boolean save(){
		FileWriter fw;
		BufferedWriter bw;
		
		if(fileContent.getPath() != null){
			try{
				fw = new FileWriter(fileContent.getPath());
				bw= new BufferedWriter(fw);
				//System.out.println("Data to save: " + fileContent.getBuffer());
				bw.write(fileContent.getBuffer());
				bw.close();
				
				//System.out.println(mediator.getMainViewText());
				fileContent.setBuffer(mediator.getMainViewText());
				fileContent.setIsSaved(true);
			}
			
			catch (IOException e1){
				System.out.println("Error saving file '" + fileContent.getPath() + "'");	
				e1.printStackTrace();
			}
			
			return true;
		}
		
		else return false;
	}
	
	/**
	 * Prompts the user to save the file with a desired name and location
	 */
	public void saveAs(String path){
		FileWriter fw;
		BufferedWriter bw;
		
		try{
			fw = new FileWriter(path);
			bw= new BufferedWriter(fw);
			System.out.println("Data to save: " + fileContent.getBuffer());
			bw.write(fileContent.getBuffer());
			bw.close();
		}
		
		catch (IOException e1){
			System.out.println("Error saving file '" + path + "'");	
			e1.printStackTrace();
		}
	}
	
	public File createNewFile(String name){
		File newFile;
		newFile = new File("",fileNumbers);
		fileNumbers +=1;
				
		fileContent.addFile(newFile);
		fileContent.changeFile(newFile.getID());
		return newFile;
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
		
		fileContent.addFile(newFile);
		fileContent.changeFile(newFile.getID());
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
	
	/**
	 * Checks to see if a tag is valid despite not following
	 * the standard tag format
	 * @param tag
	 * @return
	 */
	private boolean checksSelfClose(String tag){
		String[] selfClosing = {"meta", "link", "input"};
		
		if(Arrays.asList(selfClosing).indexOf(tag) > -1){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Sets the active file's buffer 
	 * @param s
	 */
	public void updateFileBuffer(String s){
		fileContent.setBuffer(s);
	}
	
	public void updateDisplay(){
		mediator.setTextAreaString(fileContent.getBuffer());
	}
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		if(!fileContent.getIsSaved()){
			//create prompt to ask to save
			PromptManager pm = mediator.promptManager;
			String message = "There is unsaved work. Would you like to quit without saving?";
			
			pm.displayBool(message);
		}
		
		else{
			
		}
	}	
	
	public void changeCurrentFile(int id){
		fileContent.changeFile(id);
	}
	
	public void setIsSaved(boolean b){
		fileContent.setIsSaved(b);
	}
}
