package supermarketevents;

import simulator.State;
import simulator.Event;
import customers.CreateCustomer;
import supermarket.SuperMarketState;

public class Arrive extends Event{
	
	private CreateCustomer customer;
	
	
	public Arrive(SuperMarketState state, double timearrived) {
		super(state);
		super.currentTime = timearrived;
		this.customer = new CreateCustomer();
		
		}
	
	public void execute() {
			SuperMarketState tempstate = ((SuperMarketState)currentState);
			
			if (State.isRunning()) {
				tempstate.increaseVisits();
				if (tempstate.returnmaximumCustomers() <= tempstate.returncustomersInStore()) {
					tempstate.increasedeclinedCustomers();
				}
				else if (tempstate.returnmaximumCustomers() > tempstate.returncustomersInStore()) {
					
					tempstate.increasecustomersInStore();
					double shoppingTime = currentState.returntimeAggregate() + tempstate.shoppingTime();
					currentQueue.addEvent(new ShoppingEvent(/*Shoppingevent not yet coded so no args yet*/));
				}
				
				double nextArrivalTime = tempstate.returntimeAggregate() + tempstate.nextArriveTime();
				currentQueue.addEvent(new Arrive(tempstate, nextArrivalTime));
			}
	
		
			
			
				
			
					
	}
	
	
}