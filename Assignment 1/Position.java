// ---------------------------------------------
// Rami El-Kazma - ID: 40035141
// COMP 249-U
// Assignment 1
// February 1, 2017
// ---------------------------------------------
public class Position {
	
	private boolean isCalled=false;
	private boolean isOwned=false;
	private String owner;
	private String type;
	
	/**
	 * Default constructor.
	 */
	public Position(){ //used when filling up positions not used by the computer or the player
		
	}
	
	/**
	 * Parameterized constructor.
	 * @param type an object of type String
	 * @param owner an object of type String
	 */
	public Position(String owner, String type){
		isOwned=true;
		this.owner=owner;
		this.type=type;
	}
	
	/**
	 * Checks whether or not an object has been called to identify whether there it is "owned" by a player
	 * in order to print the appropriate representation of that position.
	 * @return A string representation of an object of type Position
	 */
	public String toString(){
		if (isCalled)
		{
			if (isOwned)
				return type;
			else return "*";
		}
		else return "-";
	}
	
	/**
	 * Getter for isCalled attribute.
	 * @return a boolean value
	 */
	public boolean getIsCalled(){
		return isCalled;
	}
	
	/**
	 * Setter for isCalled attribute.
	 * @param isCalled a boolean value
	 */
	public void setIsCalled(boolean isCalled){
		this.isCalled=isCalled;
	}
	
	/**
	 * Getter for isOwned attribute.
	 * @return a boolean value
	 */
	public boolean getIsOwned(){
		return isOwned;
	}
	
	/**
	 * Setter for isOwned attribute.
	 * @param isOwned a boolean value
	 */
	public void setIsOwned(boolean isOwned){
		this.isOwned=isOwned;
	}
	
	/**
	 * Getter for owner attribute.
	 * @return an object of type String
	 */
	public String getOwner(){
		return owner;
	}
	
	/**
	 * Setter for owner attribute.
	 * @param type an object of type String
	 */
	public void setOwner(String owner){
		this.owner=owner;
	} 
	
	/**
	 * Getter for type attribute.
	 * @return an object of type String
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * Setter for type attribute.
	 * @param type an object of type String
	 */
	public void setType(String type){
		this.type=type;
	}
	
	/**
	 * Checks whether two Position objects have the same attribute values.
	 * @param position an object of type Position
	 * @return a boolean value
	 */
	public boolean equals(Position position)
	{
		return (type.equals(position.type) && isOwned == position.isOwned && isCalled == position.isCalled 
				&& owner.equals(position.owner));
	}
	
	/**
	 * Called when either player sets coordinates for firing a rocket. Changes the isCalled attribute
	 * to a true value and prints the appropriate response depending on the isOwned value followed by
	 * the type. 
	 */
	public void rocketFire(){
		isCalled=true;
		if(isOwned)
		{
			if (type.equalsIgnoreCase("g"))
				System.out.println("Boom! Grenade.\n");
			else if (type.equalsIgnoreCase("s"))
			{
				System.out.println("Ship hit!\n");
			}
		}
		else System.out.println("Nothing!\n");
	}
	
}
