// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package air_transportation;

import public_transportation.PublicTransportation;

public class AirCraft extends PublicTransportation {
	
	public enum classType {
		
		HELICOPTER, AIRLINE, GLIDER, BALLOON;
		
		public String toString(){
			return super.toString().toLowerCase();
		}
	}
	
	public enum maintenanceType {
		
		WEEKLY, MONTHLY, YEARLY;
		
		public String toString(){
			return super.toString().toLowerCase();
		}
	}
	
	private classType type;
	private maintenanceType maintenance;
	
	//default constructor
	public AirCraft(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public AirCraft(double price, int stops, classType type, maintenanceType maintenance){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		setTicketPrice(price);
		setNumberStops(stops);
		this.type=type;
		this.maintenance=maintenance;
	}
	
	//copy constructor
	public AirCraft(AirCraft ac1){
		
		setTicketPrice(ac1.getTicketPrice());
		setNumberStops(ac1.getNumberStops());
		type=ac1.type;
		maintenance=ac1.maintenance;
	}
	
	//accessors and mutators
	public classType getType(){
		return type;
	}
	
	public void setType(classType type){
		this.type=type;
	}
	
	public maintenanceType getMaintenance(){
		return maintenance;
	}
	
	public void setMaintenance(maintenanceType maintenance){
		this.maintenance=maintenance;
	}
	
	public String toString(){
		return ("The "+type+" has a ticket price of $"+getTicketPrice()+" and "+getNumberStops()+" stop(s)."
				+ " It undergoes maintenance "+maintenance+".");
	}
	
	public boolean equals(AirCraft ac1){
		
		if(ac1==null || this==null || (getClass()!=ac1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			AirCraft ac2 = (AirCraft)ac1; //casting the object
			return(getTicketPrice()==ac2.getTicketPrice() && getNumberStops()==ac2.getNumberStops() && type.equals(ac2.type) &&
					maintenance.equals(ac2.maintenance));
		}
	}

}
