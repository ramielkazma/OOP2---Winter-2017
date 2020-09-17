// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package ground_transportation;

public class Tram extends CityBus {
	
	private int maximumSpeed;
	
	//default constructor
	public Tram(){
		
		super(); //creates an object using the default constructor of the CityBus class
	}
	
	//parameterized constructor
	public Tram(double price, int stops, long route, int year, String name, String driver, int maxSpeed){
		
		super(price, stops, route, year, name, driver); //creates a CityBus object which will then create a PublicTransportation object
		setTicketPrice(price);
		setNumberStops(stops);
		setRouteNumber(route);
		setBeginOperationYear(year);
		setLineName(name);
		setDriver(driver);
		maximumSpeed=maxSpeed;
	}
	
	//copy constructor
	public Tram(Tram t1){
	
		setTicketPrice(t1.getTicketPrice());
		setNumberStops(t1.getNumberStops());
		setRouteNumber(t1.getRouteNumber());
		setBeginOperationYear(t1.getBeginOperationYear());
		setLineName(t1.getLineName());
		setDriver(t1.getDriver());
		maximumSpeed=t1.maximumSpeed;
	}
	
	//accessors and mutators
	public int getMaximumSpeed(){
		return maximumSpeed;
	}
	
	public void setMaximumSpeed(int maximumSpeed){
		this.maximumSpeed=maximumSpeed;
	}
	
	public String toString(){
		return ("This tram goes along Route "+getRouteNumber()+". It began operating in "
				+getBeginOperationYear()+". The price of a ticket is $"+getTicketPrice()+". It operates on "
				+getLineName()+" and has "+getNumberStops()+" stop(s). The driver is "+getDriver()+" "
						+ "and its maximum speed is "+maximumSpeed+" km/hr.");
	}
	
	public boolean equals(Tram t1){
		
		if(t1==null || this==null || (getClass()!=t1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Tram t2 = (Tram)t1; //casting the object
			return(getTicketPrice()==t2.getTicketPrice() && getNumberStops()==t2.getNumberStops() && getRouteNumber()==t2.getRouteNumber() &&
					getBeginOperationYear()==t2.getBeginOperationYear() && getLineName().equalsIgnoreCase(t2.getLineName()) && 
					getDriver().equalsIgnoreCase(t2.getDriver()) && maximumSpeed==t2.maximumSpeed);
		}
	}

}
