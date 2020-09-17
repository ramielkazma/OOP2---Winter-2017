// ---------------------------------------------
// Assignment 2
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// February 19, 2017
// ---------------------------------------------
package public_transportation;

public class PublicTransportation {
	
	//protected for inheriting classes to access the attributes
	protected double ticketPrice;
	protected int numberStops;

	//default constructor
	public PublicTransportation(){

	}
	
	//parameterized constructor
	public PublicTransportation(double price,int stops){
		
		ticketPrice=price;
		numberStops=stops;
	}
	
	//copy constructor
	public PublicTransportation(PublicTransportation pb1){
		ticketPrice=pb1.ticketPrice;
		numberStops=pb1.numberStops;
	}
	
	//clone method
	public PublicTransportation clone()
	{
		return new PublicTransportation(this);	// Create and return a new PublicTransportation using the copy constructor
	}
	
	//accessors
	public double getTicketPrice(){
		return ticketPrice;
	}
	
	public int getNumberStops(){
		return numberStops;
	}
	
	//mutators
	public void setTicketPrice(double ticketPrice){
		this.ticketPrice=ticketPrice;
	}
	
	public void setNumberStops(int numberStops){
		this.numberStops=numberStops;
	}
	
	public String toString(){
		return ("This public transportation has a ticket price of $"+ticketPrice+" and "+numberStops
				+" stop(s).");
	}
	
	public boolean equals(PublicTransportation pb1){
		
		if(pb1==null || this==null || (getClass()!=pb1.getClass())) //checks if either object is null and whether they are of the same type
			return false;
		else
		{
			PublicTransportation pb2 = (PublicTransportation)pb1; //casting the object
			return(ticketPrice==pb2.ticketPrice && numberStops==pb2.numberStops);
		}
	}

}
