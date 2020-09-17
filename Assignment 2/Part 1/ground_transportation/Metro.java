// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package ground_transportation;

import public_transportation.PublicTransportation;

public class Metro extends CityBus {
	
	//highest level of restriction - attribute does not need to be accessed by objects from other classes
	private int numberVehicles;
	private String cityName;
	
	//default constructor
	public Metro(){
		
		super(); //creates an object using the default constructor of the CityBus class
	}
	
	//parameterized constructor
	public Metro(double price, int stops, long route, int year, String name, String driver,
			int vehicles, String cityName){
		
		super(price, stops, route, year, name, driver); //creates a CityBus object which will then create a PublicTransportation object
		ticketPrice=price;
		numberStops=stops;
		routeNumber=route;
		beginOperationYear=year;
		lineName=name;
		this.driver=driver;
		numberVehicles=vehicles;
		this.cityName=cityName;
	}
	
	//copy constructor
	public Metro (Metro m1){
		
		ticketPrice=m1.ticketPrice;
		numberStops=m1.numberStops;
		routeNumber=m1.routeNumber;
		beginOperationYear=m1.beginOperationYear;
		lineName=m1.lineName;
		driver=m1.driver;
		numberVehicles=m1.numberVehicles;
		cityName=m1.cityName;
	}
	
	//clone method
		public Metro clone()
		{
			return new Metro(this);	// Create and return a new Metro using the copy constructor
		}
	
	//accessors and mutators
	public int getNumberVehicles(){
		return numberVehicles;
	}
	
	public void setNumberVehicles(int numberVehicles){
		this.numberVehicles=numberVehicles;
	}
	
	public String getCityName(){
		return cityName;
	}
	
	public void setCityName(String cityName){
		this.cityName=cityName;
	}
	
	public String toString(){
		return ("This metro goes along Route "+routeNumber+" in "+cityName+". It began operating in "
				+beginOperationYear+" and has "+numberVehicles+" vehicles. The price of a ticket is $"
				+ticketPrice+". It operates on line "+lineName+" and has "+numberStops+" stop(s). The driver is "+driver+".");
	}
	
	public boolean equals(Metro m1){
		
		if(m1==null || this==null || (getClass()!=m1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Metro m2 = (Metro)m1; //casting the object
			return(ticketPrice==m2.ticketPrice && numberStops==m2.numberStops && routeNumber==m2.routeNumber &&
					beginOperationYear==m2.beginOperationYear && lineName.equalsIgnoreCase(m2.lineName) && 
					driver.equalsIgnoreCase(m2.driver) && numberVehicles==m2.numberVehicles && cityName.equalsIgnoreCase(m2.cityName));
		}
	}

}
