package supermarketevents;

import simulator.Event;
import supermarket.SuperMarketState;
import customers.CustomerInformation;

public class ShoppingEvent extends Event {
	
	protected CustomerInformation customer;
	
	public ShoppingEvent (SuperMarketState state, double time, CustomerInformation customer) {
		
		super(state);
		super.currentTime = time;
		this.customer = customer;
		
	}
	
	public void execute() {
		
	}

}
