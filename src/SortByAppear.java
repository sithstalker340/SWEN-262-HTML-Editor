import java.util.ArrayList;
import java.util.List;


public class SortByAppear implements LinkedViewStrategy{
	
	private List<String> urlList;
	public SortByAppear()
	{
		urlList = new ArrayList<String>();
	}

	public List<String> parse(String buffer) {
		return urlList;
	}
}
