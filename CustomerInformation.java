package customers;

public class CustomerInformation {
	protected int customerID;
	private double arrivedAt;
	
	public CustomerInformation(int customerID) {	
		this.customerID = customerID;
		
		
	}
	public int getCustomerID( int customerID) {
		return customerID;
	}
	public double getArrivalTime(double arrivedAT) {
		return arrivedAT;
	}

}