
public class FormatHelper 
{
	String input;
	String output;
	String[] lines;
	int numTabs;
	int tagType;
	private final String TAB = "\t"; 
	
	public FormatHelper()
	{
		numTabs = 0;
		input = "";
		output = "";
		tagType = 1; //-1 = non tag, 0 = close, 1 = open
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
	
			for(int i = 0; i < numTabs+1; i++){
				tab += TAB;
			}
			
			if(checkIsTag(tempPos.substring(startPos, endPos + 1))){
				output += tab + tempPos.substring(startPos, endPos + 1) + '\n';
				
				if(tempPos.substring(startPos + 1, startPos + 2).equals("/")){
					tagType = 0;
				}
				
				else tagType = 1;
				
				
				lastEndPos = endPos;
				input = tempPos;

				//System.out.println("before: " + tempPos);
				tempPos = tempPos.substring(endPos + 1);
				//System.out.println("after: " + tempPos);
				
				
				if(tempPos.length() <= 0) break;
				

				startPos = tempPos.indexOf('<');
				endPos = tempPos.indexOf('>');

				//System.out.println("input: " + input);
				
				if(start) {
					start = !start;
					numTabs = 0;
				}
				
				else if(tempPos.length() > 0){
					int newStart = input.indexOf('<');
					//System.out.println("prev > in inuput: " + lastEndPos);
					//System.out.println("next < in input: " + newStart);
					
					tab = "";
					for(int i = 0; i < numTabs+1; i++){
						tab += TAB;
					}					
					
					output += tab + TAB + tempPos.substring(0, startPos) + '\n';	
				}
				
				if(tagType == 1 && !tempPos.substring(1, 2).equals("/")){
					numTabs++;
				}
				
				else if(tagType == 1 && tempPos.substring(1, 2).equals("/")){
					numTabs -= 1;
				}
				
				else if(tagType == -1){
					System.out.println("hit");
					
				}
				
				else {
					numTabs -= 1;
				}
			}
			
			System.out.println(tempPos.substring(startPos, endPos + 1));
			if(!checkIsTag(tempPos.substring(startPos, endPos + 1))){
				tagType = -1;
				System.out.println(tagType);
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
