
public class FormatHelper 
{
	String input;
	String output;
	String[] lines;
	int numTabs;
	boolean tagType;
	private final String TAB = "\t"; 
	
	public FormatHelper()
	{
		numTabs = 0;
		input = "";
		output = "";
		tagType = true; //true for current tab is open tab
	}
	
	public String formatTabbedString(String in)
	{
		input = in;
		output = "";
		
		String tab = "";
		String tempPos = input;
		
		int startPos = input.indexOf('<');
		int endPos = input.indexOf('>');
		
		int lastEndPos = endPos;
		boolean start = true;
		
		while(tempPos.length() > 0){
			tab = "";
			for(int i = 0; i < numTabs; i++){
				tab += TAB;
			}
			
			if(checkIsTag(tempPos.substring(startPos, endPos + 1))){
				output += tab + tempPos.substring(startPos, endPos + 1) + '\n'; 
	
				System.out.println(tempPos.substring(startPos + 1, startPos + 2));
				if(tempPos.substring(startPos + 1, startPos + 2).equals("/")){
					tagType = false;
				}
				
				else tagType = true;
				
				
				lastEndPos = endPos;
				input = tempPos;
				System.out.println("old string" + input);
				tempPos = tempPos.substring(endPos + 1);
				System.out.println("new string" + tempPos);
				if(tempPos.length() <= 0) break;
				
				System.out.println("start pos1: " + startPos);
				startPos = tempPos.indexOf('<');
				endPos = tempPos.indexOf('>');
				System.out.println("start pos2: " + startPos);
				System.out.println("new tempString: " + tempPos);
				
				if(start) {
					start = !start;
				}
				
				else if(tempPos.length() > 0 && input.substring(lastEndPos, input.indexOf(tempPos)).length() > 1){
					System.out.println("last end pos: " + lastEndPos);
					System.out.println("start pos: " + startPos);
					System.out.println("adjusted start pos: " + input.indexOf(tempPos));
					output += input.substring(lastEndPos + 1, input.indexOf(tempPos));	
				}
				
				if(tagType && !tempPos.substring(1, 2).equals("/")){
					numTabs++;
				}
				
				else if(tagType && tempPos.substring(1, 2).equals("/")){

				}
				
				else {
					numTabs--;
				}
			}
		}
		
		return output;
	}
	
	private boolean checkIsTag(String tag){
		String[] selfClosing = {"meta", "link", "input", "tr"};
		String[] normalTags = {"b", "i", "a", "header", "img", "table", "ol", "dd", "dt", "dl", "li", "td"};
		
		int endIndex = tag.indexOf('>');
		if(endIndex > 1){
			tag = tag.substring(1, tag.indexOf('>'));
		}
		
		for(int i = 0; i < selfClosing.length; i++){
			if(selfClosing[i].equals(tag)){
				return true;
			}
		}
		
		for(int i = 0; i < normalTags.length; i++){

			if(normalTags[i].equals(tag) || ('/' + normalTags[i]).equals(tag)){
				return true;
			}
			
			else if(normalTags[i].contains("a href") || normalTags[i].contains("img src")){
				return true;
			}
		}
		
		return false;
	}
}
