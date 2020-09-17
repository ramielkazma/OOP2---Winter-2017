// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package ground_transportation;

import public_transportation.PublicTransportation;

public class CityBus extends PublicTransportation {

	//all attributes are protected so that inheriting classes can have access to them (in this case could have been package)
	protected long routeNumber;
	protected int beginOperationYear;
	protected String lineName;
	protected String driver;
	
	//default constructor
	public CityBus(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public CityBus(double price, int stops, long route, int year, String name, String driver){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		ticketPrice=price;
		numberStops=stops;
		routeNumber=route;
		beginOperationYear=year;
		lineName=name;
		this.driver=driver;
	}
	
	//copy constructor
	public CityBus(CityBus cb1){
		
		ticketPrice=cb1.ticketPrice;
		numberStops=cb1.numberStops;
		routeNumber=cb1.routeNumber;
		beginOperationYear=cb1.beginOperationYear;
		lineName=cb1.lineName;
		driver=cb1.driver;
	}
	
	//clone method
		public CityBus clone()
		{
			return new CityBus(this);	// Create and return a new CityBus using the copy constructor
		}
	
	//accessors and mutators
	public long getRouteNumber(){
		return routeNumber;
	}
	
	public void setRouteNumber(long routeNumber){
		this.routeNumber=routeNumber;
	}
	
	public int getBeginOperationYear(){
		return beginOperationYear;
	}
	
	public void setBeginOperationYear(int beginOperationYear){
		this.beginOperationYear=beginOperationYear;
	}
	
	public String getLineName(){
		return lineName;
	}
	
	public void setLineName(String lineName){
		this.lineName=lineName;
	}
	
	public String getDriver(){
		return driver;
	}
	
	public void setDriver(String driver){
		this.driver=driver;
	}
	
	public String toString(){
		return ("This citybus goes along Route "+routeNumber+". It began operating in "+beginOperationYear
				+". The price of a ticket is $"+ticketPrice+". It operates on "+lineName+" and has"
						+ " "+numberStops+" stop(s). The driver is "+driver+".");
	}
	
	public boolean equals(CityBus cb1){
		
		if(cb1==null || this==null || (getClass()!=cb1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			CityBus cb2 = (CityBus)cb1; //casting the object
			return(ticketPrice==cb2.ticketPrice && numberStops==cb2.numberStops && routeNumber==cb2.routeNumber &&
					beginOperationYear==cb2.beginOperationYear && lineName.equalsIgnoreCase(cb2.lineName) && 
					driver.equalsIgnoreCase(cb2.driver));
		}
	}
	
}
