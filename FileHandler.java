
import java.util.Arrays;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {
	private FileContent mainFileContent;
	private int fileNumbers;
	public FileHandler(){
		fileNumbers = 0;
	}
	
	/**
	 * Sends the parameter command to the active file
	 * @param cmd
	 */
	public void pushCommand(Command cmd){
		mainFileContent.pushCommand(cmd);
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
		File newFile = new File(fileNumbers);
		String path = "C:\\Users\\Adam\\Desktop\\TEMP_Important\\SWEN-262\\Editor 2\\test.txt";
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(path);
			bw= new BufferedWriter(fw);
			bw.write(newFile.getBuffer());//Needs to write the buffer from the File.
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		File newFile;
		String allText = "";
		FileReader fileReader;
		BufferedReader bufferedReader;
		try{
			fileReader = new FileReader(loc);
			bufferedReader = new BufferedReader(fileReader);
			while((allText = bufferedReader.readLine()) != null) {
	                System.out.println(allText);
	            }	
			bufferedReader.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		newFile = new File(allText,fileNumbers);
		newFile.setPath(loc);
		fileNumbers +=1;
		
		return newFile;
	}
	
	/**
	 * Checks to see if the text in the current file is valid HTML
	 * @return boolean
	 */
	public boolean wellFormed(){
		Stack<String> tagStack = new Stack<String>();
		String allText = mainFileContent.toString(); // the buffer from the file
		
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
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		
	}	
}
