package patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the LinkedViewStrategy. Sorts the URL list by alphabetical order. Lists the number of occurrences.
 * @author Adam, Andrew
 *
 */
public class SortByAlpha implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	private List<Integer> urlOccurance;
	private String name;
	
	/**
	 * Constructor of the SortByAlpha class.
	 */
	public SortByAlpha(){
		urlList = new ArrayList<String>();
		urlOccurance = new ArrayList<Integer>();
		this.name = "Alphabetical Sort";
	}
	
	/**
	 *Returns the number of occurrences that each URL appear. 
	 */
	public List<Integer> numOccur(){
		return urlOccurance;
	}
	
	/**
	 * Returns the name of the Strategy type.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Looks at the buffer and stripes out the URL tags. 
	 * @return List<String>
	 */
	public List<String> parse(String buffer) {
		urlList = new ArrayList<String>();
		urlOccurance = new ArrayList<Integer>();
		
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
			end = urlList.get(i).indexOf(">");
			if(end > 0){
				urlList.set(i, urlList.get(i).substring(0,end));
			}
		}

		sort();
		return urlList;
	}
	
	/**
	 * Orders the URL list in alphabetical order.
	 */
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
}