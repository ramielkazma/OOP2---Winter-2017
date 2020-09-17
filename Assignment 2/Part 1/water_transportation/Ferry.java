// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package water_transportation;

import public_transportation.PublicTransportation;

public class Ferry extends PublicTransportation {
	
	//highest level of restriction - attribute does not need to be accessed by objects from other classes
	private int buildYear;
	private String shipName;
	
	//default constructor
	public Ferry(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public Ferry(double price, int stops, int year, String name){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		ticketPrice=price;
		numberStops=stops;
		buildYear=year;
		shipName=name;
	}
	
	//copy constructor
	public Ferry(Ferry f1){
		
		ticketPrice=f1.ticketPrice;
		numberStops=f1.numberStops;
		buildYear=f1.buildYear;
		shipName=f1.shipName;
	}
	
	//clone method
		public Ferry clone()
		{
			return new Ferry(this);	// Create and return a new Ferry using the copy constructor
		}
	
	//accessors and mutators
	public int getBuildYear(){
		return buildYear;
	}
	
	public void setBuildYear(int buildYear){
		this.buildYear=buildYear;
	}
	
	public String getShipName(){
		return shipName;
	}
	
	public void setShipName(String shipName){
		this.shipName=shipName;
	}
	
	public String toString(){
		return ("The "+shipName+" ferry has a ticket price of $"+ticketPrice+" and "+numberStops+" stop(s). It was built in "+buildYear+".");
	}
	
	public boolean equals(Ferry f1){
		
		if(f1==null || this==null || (getClass()!=f1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Ferry f2 = (Ferry)f1; //casting the object
			return(ticketPrice==f2.ticketPrice && numberStops==f2.numberStops && buildYear==f1.buildYear &&
					shipName.equalsIgnoreCase(f2.shipName));
		}
	}

}
