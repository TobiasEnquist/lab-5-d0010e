package simulator;

public class Simulator {
	private State currentState;
	private EventQueue eventQueue;
	private View currentView;
	
	public Simulator(State currentState, EventQueue eventQueue, View currentView) {
		this.currentState = currentState;
		this.eventQueue = eventQueue;
		this.currentView = currentView;
	}
	private void run() {
		while(currentState.isRunning() && eventQueue.hasNext()) {
			eventQueue.firstInLine();
		}
	}
}