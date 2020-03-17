package supermarket;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.Event;
import simulator.State;

public class SuperMarketState extends State{
	/**
	 * Static variables is introduced.
	 * 
	 * First set: Gross amount of checkouts and the avaliable amount of checkouts.
	 * Second set: Upper & Lower quartile value of slow and fast checkouts.
	 *Third set: Self Explaining 
	 *Fourth set: Self Explaining
	 *Fifth set: S
	 * @param
	 */
	private static int grossFastCheckouts = 2;
	private	static int grossSlowCheckouts = 2;
	static int	availableFastCheckouts = 2;
	static int	availableSlowCheckouts = 2;
	
	static double spreadFastInferior = 1.0;
	static double spreadFastSuperior = 4.0;
	static double spreadSlowInferior = 3.0;
	static double spreadSlowSuperior = 6.0;
	
	static double currentTime = 0.00;
	
	static double grossQueueTime = 0.00;
	static double grossIdleTime = 0.00;
	
	static double formerCurrentTime = 0.00;
	static double formerGrossQueueTime = 0.00;
	
	static double lambda = 4; //Increase uniqueness
	static int seed = 1234;
	
	
	public int visits;
	public int maximumCustomers;
	public int maximumRegisters;
	public int registers;
	public int customersInStore;
	public int declinedCustomers;
	public int paid;
	public FIFO queueForLeaving;
	
	
	
		
	
	private UniformRandomStream shopping;
	private	UniformRandomStream leave;
	private ExponentialRandomStream arrive;
	
	
	public SuperMarketState(double lambda, double pickMin,double pickMax, double leaveMin, double leaveMax, long seed) {
		this.arrive = new ExponentialRandomStream(lambda, seed);
		this.shopping = new UniformRandomStream(pickMin,pickMax, seed);
		this.leave = new UniformRandomStream(leaveMin,leaveMax, seed);

	}
	
	public double nextArriveTime() {
		return arrive.next();
	}
	
	public double shoppingTime() {
		return shopping.next();
	}
	
	public double leaveTime() {
		return leave.next();
	}
	
	
	double	novelEventTime() {
		currentTime += timeToNextCustomerArrival.next();
		return currentTime;
	}
	double getFastCheckoutTime() {
		return fastCheckoutTime.next();
	}	
	double getSlowCheckoutTime() {
		return slowCheckoutTime.next();
		
	}
	void updateGrossIdleTime(Event evt) {
		grossIdleTime += (evt.time - formerCurrentTime) * (avaliableFastCheckouts + avaliableSlowCheckouts);
		formerCurrentTime = evt.time;
	}
	static boolean fastCheckoutsAvaliable() {
		return (availableFastCheckouts > 0) ? true:false;
	}
	static boolean slowAvaliable() {
		return (availableSlowCheckouts > 0) ? true:false;
	}
	static int getGrossSlowCheckouts() {
		return grossSlowCheckouts;
	}
	
	static int getGrossFastCheckouts() {
		return grossFastCheckouts;
	}
	
	
	public void increaseVisits() {
		visits++;
	}
	
	public void increasecustomersInStore() {
		customersInStore++;
	}
	
	public void decreasecustomersInStore() {
		customersInStore--;
	}
	
	public void increasedeclinedCustomers() {
		declinedCustomers++;
	}
	
	public int returnvisits() {
		return visits;
	}
	
	public int returnmaximumCustomers() {
		return maximumCustomers;
	}
	
	public int returncustomersInStore() {
		return customersInStore;
	}
	
	public int returndeclinedCustomers() {
		return declinedCustomers;
	}
	
	public double returntimeAggregate() {
		return timeAggregate;
	}
	
	public int returnpaid() {
		return paid;
	}
	
	public void increasepaid() {
		paid++;
	}
	
	public FIFO returnqueueForLeaving() {
		return queueForLeaving;
	}
	
	public void createRegister() {
		
		if (maximumRegisters > registers) {
			registers++;
		}
		else {
			System.out.println("Cannot open further registers");
		
		}
	}
	
	

	
	
	
	

}