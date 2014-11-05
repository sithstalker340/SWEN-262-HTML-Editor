import java.util.ArrayList;
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
		return fileContent.getActiveFile() != null;
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
		newFile.setIsFunctional(true);
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
		
		//System.out.println(getIsFunctional());
		//System.out.println(getIsFunctional());
				
		fileContent.addFile(newFile);
		fileContent.changeFile(newFile.getID());
		setIsFunctional();
		return newFile;
	}
	
	public boolean close(int id){
		//If the file is unsaved, then prompt user to continue
		File file = fileContent.getFileByID(id);
		
		if(file.isSaved()){
			fileContent.removeFile(file); //removes the file from the list
			return true; //tells tabView to remove Tab
		}else{
			if( mediator.promptManager.displayBool(
					"The file you are attempting to close is not saved. Do you wish to proceed?")){
				fileContent.removeFile(file); //removes the file from the list
				return true; //tells tabView to remove Tab
			}else{
				return false;
			}
		}
	}
	
	/**
	 * Checks to see if the text in the current file is valid HTML
	 * @return boolean
	 */
	public boolean wellFormed(File file){
		if(file == null){
			return false;
		}
		
		List<String> leftOverTags = new ArrayList<String>();
		Stack<String> tagStack = new Stack<String>();
		String allText = file.getBuffer(); // the buffer from the file		
			
		int start = allText.indexOf('<');
		int end = allText.indexOf('>');
		String tag = "";
			
		if((start == -1 || end == -1) || start > end){
			if(start == -1 && end == -1){
				//if there are no html tags in the file
				return true;
			}
				
			//missing a > or <
			notifyIllformed();
			return false;
		}
		
	
		while((start != -1 && end != -1)){
			if(start >= end){
				notifyIllformed();
				return false;
			}
			
			tag = allText.substring(start + 1, end); // changes tag from <b> to b>
			//if it is an open tag
			if(tag.charAt(0) != '/'){				
				if(tag.charAt(0) != '!'){ //ignores the opening <!HTMLDOC> tag
					System.out.println("tag: " + tag);
					if(checksSelfClose(tag)){
						leftOverTags.add(tag);
						//System.out.println("tag is self closing");
					}			
					
					else if(tag.contains("img src")){ //for <img src...> tags
						tag = "img";
						tagStack.push(tag);
					}
					
					else if(tag.contains("a href")){ //for <a href...> tags
						tag = "a";
						tagStack.push(tag);
					}			
					
					else{ tagStack.push(tag); //System.out.println("tag pushed: " + tag); 
					}
				}
			}
			

			//if it is a close tag
			else if(tag.charAt(0) == '/'){
				tag = tag.substring(tag.indexOf('/') + 1); //find the actual tag by removing the close character
				if(tagStack.peek().equals(tag)){ //check to see if the most recent tag is the open tag for this close tag
					tagStack.pop(); //if it is remove the open tag
					//System.out.println("tag popped: " + tag);
				}
				
				else{
					//a mismatched close tag has been found
					notifyIllformed();
					return false;
				}
			}
				
				
			//update the text to go through
			allText = allText.substring(end+1);
			start = allText.indexOf('<'); //find the next tag start and end
			end = allText.indexOf('>');	
		}
			
		
		//if there are leftover tags that arent closed, and they aren't self closing tags  
		if(tagStack.size() != 0 && tagStack.size() != leftOverTags.size()){
			notifyIllformed();
			return false;
		}
		
		else return true;
	}
	
	private void notifyIllformed(){
		mediator.promptManager.displayMessage("Your file contains illformed HTML, some functionality may be disabled till this is corrected");
	}
	
	/**
	 * Checks to see if a tag is valid despite not following
	 * the standard tag format
	 * @param tag
	 * @return
	 */
 	private boolean checksSelfClose(String tag){
		String[] selfClosing = {"meta", "link", "input", "tr"};
		
		for(int i = 0; i < selfClosing.length; i++){
			if(selfClosing[i].equals(tag)){
				return true;
			}
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
	
	public boolean getIsFunctional(){
		setIsFunctional();
		return fileContent.getIsFunctional();
	}
	
	public void setIsFunctional(){
		fileContent.setIsFunctional(wellFormed(fileContent.getActiveFile()));
	}
}
