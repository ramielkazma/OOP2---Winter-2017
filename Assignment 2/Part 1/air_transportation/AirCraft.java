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
	
	//enumerations
	public enum classType {
		
		HELICOPTER, AIRLINE, GLIDER, BALLOON;
		
		//override toString method to print the values in lower case
		public String toString(){
			return super.toString().toLowerCase();
		}
	}
	
	public enum maintenanceType {
		
		WEEKLY, MONTHLY, YEARLY;
		
		//override toString method to print the values in lower case
		public String toString(){
			return super.toString().toLowerCase();
		}
	}
	
	//highest level of restriction - attribute does not need to be accessed by objects from other classes
	private classType type;
	private maintenanceType maintenance;
	
	//default constructor
	public AirCraft(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public AirCraft(double price, int stops, classType type, maintenanceType maintenance){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		ticketPrice=price;
		numberStops=stops;
		this.type=type;
		this.maintenance=maintenance;
	}
	
	//copy constructor
	public AirCraft(AirCraft ac1){
		
		ticketPrice=ac1.ticketPrice;
		numberStops=ac1.numberStops;
		type=ac1.type;
		maintenance=ac1.maintenance;
	}
	
	//clone method
		public AirCraft clone()
		{
			return new AirCraft(this);	// Create and return a new AirCraft using the copy constructor
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
		return ("The "+type+" has a ticket price of $"+ticketPrice+" and "+numberStops+" stop(s). It undergoes maintenance "+maintenance+".");
	}
	
	public boolean equals(AirCraft ac1){
		
		if(ac1==null || this==null || (getClass()!=ac1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			AirCraft ac2 = (AirCraft)ac1; //casting the object
			return(ticketPrice==ac2.ticketPrice && numberStops==ac2.numberStops && type.equals(ac2.type) &&
					maintenance.equals(ac2.maintenance));
		}
	}

}
