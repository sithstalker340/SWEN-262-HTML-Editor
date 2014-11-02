
public class InputHandler {

	private Mediator mediator; 
	public MainView mainView;
	
	public InputHandler(Mediator m){
		mediator = m;
	}
	
	public void setMainView(MainView m){
		mainView = m;
	}
	
	public Mediator getMediator(){
		return mediator;
	}
}
