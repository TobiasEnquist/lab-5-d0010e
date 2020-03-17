package simulator;


public abstract class Event {
public State currentState;
public EventQueue currentQueue;
protected double currentTime;




	public Event(State currentState) {
		this.currentState = currentState;

}
	

	public State getCurrentState() {
		return currentState;
	}
	public EventQueue getCurrentQueue() {
		return currentQueue;
	}
	public double getCurrentTime () {
		return currentTime;
	}
	public abstract void execute() ;
	
	
}