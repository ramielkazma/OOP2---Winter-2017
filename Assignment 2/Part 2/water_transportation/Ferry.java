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
	
	private int buildYear;
	private String shipName;
	
	//default constructor
	public Ferry(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public Ferry(double price, int stops, int year, String name){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		setTicketPrice(price);
		setNumberStops(stops);
		buildYear=year;
		shipName=name;
	}
	
	//copy constructor
	public Ferry(Ferry f1){
		
		setTicketPrice(f1.getTicketPrice());
		setNumberStops(f1.getNumberStops());
		buildYear=f1.buildYear;
		shipName=f1.shipName;
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
		return ("The "+shipName+" ferry has a ticket price of $"+getTicketPrice()+" and "+getNumberStops()
				+" stop(s). It was built in "+buildYear+".");
	}
	
	public boolean equals(Ferry f1){
		
		if(f1==null || this==null || (getClass()!=f1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Ferry f2 = (Ferry)f1; //casting the object
			return(getTicketPrice()==f2.getTicketPrice() && getNumberStops()==f2.getNumberStops() && buildYear==f1.buildYear &&
					shipName.equalsIgnoreCase(f2.shipName));
		}
	}

}
