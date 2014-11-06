import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Implementation of the LinkedViewStrategy. Sorts the URL list by order of appearance.
 * @author Adam, Andrew
 *
 */
public class SortByAppear implements LinkedViewStrategy{
	private String[] splitText;
	private List<String> urlList;
	private String name;
	
	/**
	 * Constructor of the SortByAppear class.
	 */
	public SortByAppear()
	{
		urlList = new ArrayList<String>();
		this.name = "Appearance Sort";
	}
	
	/**
	 * Returns null beacause this method is only used in SortByAlpha.
	 */
	public List<Integer> numOccur() {
		return null;
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
	public List<String> parse(String buffer){
		urlList = new ArrayList<String>();
		
		splitText = buffer.split("[\n]+");
		String[] tempList;
		
		for(int i = 0; i < splitText.length; i++){
			tempList = splitText[i].split("<a href=+");
			
			for(int j = 0; j < tempList.length; j++){
				if(tempList[j].startsWith("\"")){
					urlList.add(tempList[j]);
				}
			}
		}
		
		int end;
		for(int i = 0; i < urlList.size(); i++){
			end = urlList.get(i).indexOf(">");
			if(end > 0){
				urlList.set(i, urlList.get(i).substring(0,end));
			}
		}
		
		return urlList;
	}
}