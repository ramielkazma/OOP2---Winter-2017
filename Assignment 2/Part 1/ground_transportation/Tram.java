// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package ground_transportation;

import public_transportation.PublicTransportation;

public class Tram extends CityBus {
	
	//highest level of restriction - attribute does not need to be accessed by objects from other classes
	private int maximumSpeed;
	
	//default constructor
	public Tram(){
		
		super(); //creates an object using the default constructor of the CityBus class
	}
	
	public Tram(double price, int stops, long route, int year, String name, String driver, int maxSpeed){
		
		super(price, stops, route, year, name, driver); //creates a CityBus object which will then create a PublicTransportation object
		ticketPrice=price;
		numberStops=stops;
		routeNumber=route;
		beginOperationYear=year;
		lineName=name;
		this.driver=driver;
		maximumSpeed=maxSpeed;
	}
	
	//copy constructor
	public Tram(Tram t1){
	
		ticketPrice=t1.ticketPrice;
		numberStops=t1.numberStops;
		routeNumber=t1.routeNumber;
		beginOperationYear=t1.beginOperationYear;
		lineName=t1.lineName;
		driver=t1.driver;
		maximumSpeed=t1.maximumSpeed;
	}
	
	//clone method
		public Tram clone()
		{
			return new Tram(this);	// Create and return a new Tram using the copy constructor
		}
	
	//accessors and mutators
	public int getMaximumSpeed(){
		return maximumSpeed;
	}
	
	public void setMaximumSpeed(int maximumSpeed){
		this.maximumSpeed=maximumSpeed;
	}
	
	public String toString(){
		return ("This tram goes along Route "+routeNumber+". It began operating in "
				+beginOperationYear+". The price of a ticket is $"+ticketPrice+". It operates on "
				+lineName+" and has "+numberStops+" stop(s). The driver is "+driver+" "
						+ "and its maximum speed is "+maximumSpeed+" km/hr.");
	}
	
	public boolean equals(Tram t1){
		
		if(t1==null || this==null || (getClass()!=t1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Tram t2 = (Tram)t1; //casting the object
			return(ticketPrice==t2.ticketPrice && numberStops==t2.numberStops && routeNumber==t2.routeNumber &&
					beginOperationYear==t2.beginOperationYear && lineName.equalsIgnoreCase(t2.lineName) && 
					driver.equalsIgnoreCase(t2.driver) && maximumSpeed==t2.maximumSpeed);
		}
	}

}
