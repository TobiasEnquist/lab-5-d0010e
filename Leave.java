package supermarketevents;

import simulator.Event;
import customers.CustomerInformation;
import supermarket.SuperMarketState;

public class Leave extends Event{


	
	public Leave(CustomerInformation customer, SuperMarketState state, double time) {
		super(state);
		super.currentTime = time;
	}
	
	public void execute() {
		SuperMarketState tempstate = ((SuperMarketState) currentState);
		tempstate.increasepaid();
		tempstate.decreasecustomersInStore();
		if(tempstate.queueForLeaving.isEmpty()) {
			tempstate.createRegister();
		} else if(!(tempstate.queueForLeaving.isEmpty())) {
			
			double leavingTime = tempstate.returntimeAggregate() + tempstate.leaveTime();
			tempstate.returnqueueForLeaving().removeFirst();
			CustomerInformation nextCustomer = tempstate.returnqueueForLeaving().first();
			currentQueue.addEvent(new Leave(nextCustomer, tempstate, leavingTime));
			
		}
			
		
	}

}
