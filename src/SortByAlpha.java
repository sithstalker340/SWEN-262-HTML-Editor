import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortByAlpha implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	
	public SortByAlpha(){
		urlList = new ArrayList<String>();
	}

	public List<String> parse(String buffer) {
		splitText = buffer.split("[\n]+");
		String[] tempList;
		for(int i = 0;i < splitText.length;i++){
			tempList = splitText[i].split("</a>+");
			for(int j = 0;j<tempList.length;j++){
				urlList.add(tempList[j] + "</a>");
				
			}
		Collections.sort(urlList);
		}
		return urlList;
	}
}