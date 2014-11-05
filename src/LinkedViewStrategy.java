import java.util.List;

public interface LinkedViewStrategy {
	
	public List<String> parse(String buffer);
	
	public List<Integer> numOccur();
	
	public String getName();
}
