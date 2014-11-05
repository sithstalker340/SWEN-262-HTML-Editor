import java.util.ArrayList;
import java.util.List;


public class SortByAppear implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	
	public SortByAppear()
	{
		urlList = new ArrayList<String>();
	}

	public List<String> parse(String buffer) {
		splitText = buffer.split("[\n]+");
		for(int i = 0;i < splitText.length;i++){
			if(splitText[i].contains("<a href=")){
				urlList.add(splitText[i]);
			}
		}
		return urlList;
	}
}
