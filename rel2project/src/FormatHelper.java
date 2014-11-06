import java.util.Arrays;


public class FormatHelper 
{
	String[] selfClosing = {"meta", "link", "input"};
	String[] normalTags = {"b", "i", "a", "header", "img", "table", "ol", "dd", "dt", "dl", "li", "td", "tr"};
	
	
	public FormatHelper()
	{
	}
	
	//assume in is well formed
	public String formatTabbedString(String in)
	{
		int numTabs = 0;
		boolean inTag = false;
		//find instance of tag, open and end.  pass that string into another function to format
		String result = "";
		
		int start = in.indexOf('<');
		int end = in.indexOf('>');
		
		if(start == -1 || end == -1){
			System.out.println("No well formed tags found");
			return in;
		}
		
		//Add text before first tag
		if( start > 0){
			result += in.substring(0, start);
		}
		
		//start loop
		while( start > -1 && end > -1 ){
			String tag = in.substring(start + 1,  end); // the string between the two tags found
			
			boolean isOpen = true;
			if(tag.indexOf('/') == 0){
				//This tag is a closing tag
				tag = tag.substring(1);
				isOpen = false;
				if(inTag){
					inTag = false;
				}else{
					if(numTabs != 0)
						numTabs--;
				}
			}else{
				if(inTag){
					numTabs++;
				}else{
					inTag = true;
				}
			}
			
			if(numTabs < 0){
				System.out.println("Too many close tags");
				return in;
			}
			
			//IS IT A VALID TAG
			if(tag.indexOf('=') > -1){ // tag is either A or IM
				if(tag.indexOf("a href=") == 0){
					//tag is a link				
				}else if(tag.indexOf("img src=") == 0){
					//tag is an img
				}else{
					System.out.println("Found non-supported tag: " + tag);
					return in;
				}
			}else if(Arrays.asList(normalTags).contains(tag)){
				//Tag is a normal tag			
			}else if(Arrays.asList(selfClosing).contains(tag)){
				//Tag is self closing
				numTabs--;
				if(numTabs == -1)
					numTabs = 0;
			}else{
				System.out.println("Found non-supported tag: " + tag);
				return in;
			}
			
			//Tag is valid, oepnTag ( true = open, false = close )
	
			result += formatTag(tag, numTabs, isOpen);
			
			//Update start values
			start = in.indexOf('<', end + 1);
			end = in.indexOf('>', end + 1);
			
			if((end == -1 && start > -1) || (start == -1 && end > -1)){
				System.out.println("Missmatch tags");
				return in;
			}
		}
		//end loop		
		
		//ADD REMIAINING STRING TO END OF RESULT
		int p = -1; 
		end = in.indexOf('>');
		while(end > -1){
			p = end;
			end = in.indexOf('>', end + 1);
		}
		
		if(p + 1 < in.length()){
		result += in.substring(p);
		}
		
		return result;		
	}
	
	private String formatTag(String tag, int numTabs, Boolean isOpen){
		String result = "";
		if(isOpen){
			result += getTabs(numTabs) + '<' + tag + '>' + '\n';
		}else{
			result += getTabs(numTabs) + "</" + tag + '>' + '\n';
		}
		return result;
	}
	
	
	private String getTabs(int i){
		String result = "";
		for(int k = 0; k < i; k++){
			result += '\t';
		}
		return result;
	} 

}
