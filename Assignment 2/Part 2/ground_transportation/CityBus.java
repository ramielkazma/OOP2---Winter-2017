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

	private long routeNumber;
	private int beginOperationYear;
	private String lineName;
	private String driver;
	
	//default constructor
	public CityBus(){
		
		super(); //creates an object using the default constructor of the PublicTransportation class
	}
	
	//parameterized constructor
	public CityBus(double price, int stops, long route, int year, String name, String driver){
		
		super(price, stops); //creates an object using the parameterized constructor of the PublicTransportation class
		setTicketPrice(price);
		setNumberStops(stops);
		routeNumber=route;
		beginOperationYear=year;
		lineName=name;
		this.driver=driver;
	}
	
	public CityBus(CityBus cb1){
		
		setTicketPrice(cb1.getTicketPrice());
		setNumberStops(cb1.getNumberStops());
		routeNumber=cb1.routeNumber;
		beginOperationYear=cb1.beginOperationYear;
		lineName=cb1.lineName;
		driver=cb1.driver;
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
				+". The price of a ticket is $"+getTicketPrice()+". It operates on "+lineName+" and has"
						+ " "+getNumberStops()+" stop(s). The driver is "+driver+".");
	}
	
	public boolean equals(CityBus cb1){
		
		if(cb1==null || this==null || (getClass()!=cb1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			CityBus cb2 = (CityBus)cb1; //casting the object
			return(getTicketPrice()==cb2.getTicketPrice() && getNumberStops()==cb2.getNumberStops() && routeNumber==cb2.routeNumber &&
					beginOperationYear==cb2.beginOperationYear && lineName.equalsIgnoreCase(cb2.lineName) && 
					driver.equalsIgnoreCase(cb2.driver));
		}
	}
	
}
