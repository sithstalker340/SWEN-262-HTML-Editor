import java.util.ArrayList;
import java.util.List;

public class SortByAlpha implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	private List<Integer> urlOccurance;
	
	public SortByAlpha(){
		urlList = new ArrayList<String>();
		urlOccurance = new ArrayList<Integer>();
	}

	public List<String> parse(String buffer) {
		splitText = buffer.split("[\n]+");
		String[] tempList;
		
		for(int i = 0; i < splitText.length; i++){ //goes through each line of code
			tempList = splitText[i].split("<a href=+");
			
			for(int j = 0; j < tempList.length; j++){
				if(tempList[j].startsWith("\"")){
					if(urlList.contains(tempList[j])){
						int element = urlList.indexOf(tempList[j]);
						urlOccurance.set(element, urlOccurance.get(element) + 1);
					}
					
					else{
						urlList.add(tempList[j]);
						urlOccurance.add(1);
					}
				}
			}
		}
		
		int end = 0;
		
		for(int i = 0; i < urlList.size(); i++){
			end = urlList.get(i).indexOf("></a>");
			urlList.set(i, urlList.get(i).substring(0,end));
		}
		
		//Collections.sort(urlList);
		sort();
		return urlList;
	}
	
	private void sort(){
		int j;
		boolean flag = true;
		String temp1;
		int temp2;
		
		while(flag){
			flag = false;
			for(j = urlList.size() - 1; j > 0; j--){
				if(urlList.get(j).compareTo(urlList.get(j - 1)) < 0){
					temp1 = urlList.get(j);
					urlList.set(j, urlList.get(j - 1));
					urlList.set(j - 1, temp1);
					
					temp2 = urlOccurance.get(j);
					urlOccurance.set(j, urlOccurance.get(j - 1));
					urlOccurance.set(j - 1, temp2);
					
					flag = true;
				}
			}
		}
	}
	
	public List<Integer> numOccur() {
		return urlOccurance;
	}
}