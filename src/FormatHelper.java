
public class FormatHelper 
{
	String input;
	String output;
	String[] lines;
	int numTabs;
	private final String TAB = "\t"; 
	
	public FormatHelper()
	{
		numTabs = 0;
		input = "";
		output = "";
	}
	
	public String getPrettyPrint(String in)
	{
		input = in;
		output = "";
		
		lines = input.split("[\n]+");
		String[] tempList;
		
		for(int i = 0; i < lines.length; i++)//goes through each line of code
		{ 
			tempList = lines[i].split("<(.*)>,<\\\\(.*)>");
			
			String tempStr = "";
			
			for(int j = 0; j < tempList.length; j++)
			{
				for(int k = 0; k < numTabs; k++)
				{
					tempList[j] = TAB + tempList[j];
				}
				
				if(!tempList[j].startsWith("<\\"))
				{
					numTabs += 1;
				}	
				else
				{
					numTabs -= 1;
				}
				tempStr += tempList[j];
			}
		
			lines[i] = tempStr;
		}
		
		//goes through file and every tag it encounters increment numTabs
		for(int l = 0; l < lines.length; l++)
		{
			output = output + lines[l];
		}
		
		return output;
	}
	
}
