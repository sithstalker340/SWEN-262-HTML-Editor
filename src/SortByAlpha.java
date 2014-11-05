import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortByAlpha implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	private List<Integer> urlOccurance;
	
	public SortByAlpha(){
		urlList = new ArrayList<String>();
	}

	public List<String> parse(String buffer) {
		splitText = buffer.split("[\n]+");
		String[] tempList;
		for(int i = 0;i < splitText.length;i++){
			tempList = splitText[i].split("<a href=+");
			for(int j = 0;j<tempList.length;j++){
				if(tempList[j].startsWith("\"")){
					if(urlList.contains(tempList[j])){
						
					}
				
					else{
						urlList.add(tempList[j]);
					}
				}
			}
		}
		
		int end;
		for(int i = 0;i < urlList.size();i++){
			end = urlList.get(i).indexOf("></a>");
			urlList.set(i, urlList.get(i).substring(0,end));
		}
		Collections.sort(urlList);
		return urlList;
	}
}