package simulator;
import java.util.ArrayList;
import java.util.Observable;

public class State extends Observable {
	
	public double timeAggregate = 0;
	private static boolean running = false;
	public EventQueue eventQueue;
	
	public State() {
		this.timeAggregate = timeAggregate;
		this.running = running;
		this.eventQueue = eventQueue;
		
	}
	

 
	public void start() {
		running = true;
		
	}
	
	public void stop() {
		running = false;
	}
	
	public void updateTimeAggregate(double addedTime) {
		timeAggregate = timeAggregate +addedTime;
	}
	
	public void updateObservers(Event event) {
		setChanged();
		notifyObservers(event);
		
	}

	public static boolean isRunning() {
		return running;
	}
	
	public double returntimeAggregate() {
		return timeAggregate;
	}
}