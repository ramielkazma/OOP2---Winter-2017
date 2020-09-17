// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package ground_transportation;

public class Metro extends CityBus {
	
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
		setTicketPrice(price);
		setNumberStops(stops);
		setRouteNumber(route);
		setBeginOperationYear(year);
		setLineName(name);
		setDriver(driver);
		numberVehicles=vehicles;
		this.cityName=cityName;
	}
	
	//copy constructor
	public Metro (Metro m1){
		
		setTicketPrice(m1.getTicketPrice());
		setNumberStops(m1.getNumberStops());
		setRouteNumber(m1.getRouteNumber());
		setBeginOperationYear(m1.getBeginOperationYear());
		setLineName(m1.getLineName());
		setDriver(m1.getDriver());
		numberVehicles=m1.numberVehicles;
		cityName=m1.cityName;
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
		return ("This metro goes along Route "+getRouteNumber()+" in "+cityName+". It began operating in "
				+getBeginOperationYear()+" and has "+numberVehicles+" vehicles. The price of a ticket is $"
				+getTicketPrice()+". It operates on line "+getLineName()+" and has "+getNumberStops()
				+" stop(s). The driver is "+getDriver()+".");
	}
	
	public boolean equals(Metro m1){
		
		if(m1==null || this==null || (getClass()!=m1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			Metro m2 = (Metro)m1; //casting the object
			return(getTicketPrice()==m2.getTicketPrice() && getNumberStops()==m2.getNumberStops() && getRouteNumber()==m2.getRouteNumber() &&
					getBeginOperationYear()==m2.getBeginOperationYear() && getLineName().equalsIgnoreCase(m2.getLineName()) && 
					getDriver().equalsIgnoreCase(m2.getDriver()) && numberVehicles==m2.numberVehicles && 
					cityName.equalsIgnoreCase(m2.cityName));
		}
	}

}
