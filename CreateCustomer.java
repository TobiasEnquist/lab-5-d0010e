package customers;

import customers.CustomerInformation;

public class CreateCustomer{
	
	private int customerID;
	
	
	public CreateCustomer() {
		this.customerID = customerID;
		customerID++;
		
	}
	

	/**
	public CreateCustomer assignCustomerID () {
		setCustomerID(getCustomerID() + 1);
		return new CreateCustomer();
	}
	*/
	
		
	

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}