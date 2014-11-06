import java.util.List;

/**
 * Abtract Strategy for the LinkedView class.
 * @author Adam
 *
 */
public interface LinkedViewStrategy {
	
	public List<String> parse(String buffer);
	
	public List<Integer> numOccur();
	
	public String getName();
}
