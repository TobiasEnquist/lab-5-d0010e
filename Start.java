package simulator;

public abstract class Start extends Event {
	
	public Start(State state) {
		super(state);
		this.currentTime = 0;
	}

}
