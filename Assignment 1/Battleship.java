// ---------------------------------------------
// Rami El-Kazma - ID: 40035141
// COMP 249-U
// Assignment 1
// February 1, 2017
// ---------------------------------------------
import java.util.Scanner;
public class Battleship {

	Scanner myKeyboard = new Scanner(System.in);
	private String sCoords="", gCoords="", rCoords="";
	private final int gridSize=8, ships=6, grenades=4;
	private int humanShips=6, computerShips=6, humanMissedTurns=0, computerMissedTurns=0;
	private Position[][] battleField;
	private boolean humanGrenade=true, computerGrenade=true;
	private boolean setUp=false, game=true;

	/**
	 * Default constructor.
	 * Creates a 2D array of objects of type Position where the players will set their ships and
	 * grenades. 
	 */
	public Battleship(){
		battleField=new Position[gridSize][gridSize];
	}
	
	/**
	 * Places the ships and grenades in the array according to the user's choice.
	 * This method asks for the user input, checks the validity of the input -using the 
	 * humanCheckCoordinates method- and initializes the array of Position objects accordingly.
	 * @see <a href="Battleship.html#humanCheckCoordinates-java.lang.String-">humanCheckCoordinates</a>
	 */
	public void humanPlace(){

		boolean validCoordinates = false;

		for (int i=1;i<=ships;i++)
		{
			while (!validCoordinates) //loops when invalid coordinates are entered to allow the user to 
									  //correctly place their ships
			{
				System.out.print("Enter the coordinates for your SHIP #"+i+": ");
				sCoords=myKeyboard.next().toUpperCase(); //ex. a8 is the same as A8
				if (humanCheckCoordinates(sCoords))
					validCoordinates=true; //when the entered coordinates are valid
			}
			battleField[sCoords.charAt(1)-'1'][sCoords.charAt(0)-'A']=new Position("H","s");
			validCoordinates=false;
		}
		
		for (int i=1;i<=grenades;i++)
		{
			while(!validCoordinates)
			{
				System.out.print("Enter the coordinates for your GRENADE #"+i+": ");
				gCoords=myKeyboard.next().toUpperCase();
				if(humanCheckCoordinates(gCoords))
					validCoordinates=true;
			}
			battleField[gCoords.charAt(1)-'1'][gCoords.charAt(0)-'A']=new Position("H","g");
			validCoordinates=false;
		}
	}
	
	/**
	 * Places the computer's ships and grenades in the array randomly -using the randomSelection method-
	 * and initializes the array of Position objects accordingly.
	 * This method randomly selects a position in the array, checks the validity of the input -using the 
	 * computerCheckCoordinates method- and loops until the coordinates are valid.
	 * @see <a href="Battleship.html#randomSelection-java.lang.String-">randomSelection</a>
	 * @see <a href="Battleship.html#computerCheckCoordinates-java.lang.String-
	 * ">computerCheckCoordinates</a>
	 */
	public void computerPlace(){
		
		boolean validCoordinates = false;
		for (int i=1;i<=ships;i++) //uses same logic as humanPlace() method
		{
			while(!validCoordinates)
			{
				sCoords=randomSelection();
				if (computerCheckCoordinates(sCoords))
					validCoordinates=true;
			}
			battleField[sCoords.charAt(1)-'1'][sCoords.charAt(0)-'A']=new Position("C","S");
			validCoordinates=false;
		}
		
		for (int i=1;i<=grenades;i++)
		{
			while(!validCoordinates)
			{
				gCoords=randomSelection();
				if (computerCheckCoordinates(gCoords))
					validCoordinates=true;
			}
			battleField[gCoords.charAt(1)-'1'][gCoords.charAt(0)-'A']=new Position("C","G");
			validCoordinates=false;
		}
		
		System.out.println("\nThe computer placed its ships and grenades. Let the games"
				+ " begin!"
				+ "\n");
	}
	
	/**
	 * Random selection of coordinates for the computer to place ships and grenades or fire rockets.
	 * @return the randomly selected coordinates as an object of type String
	 */
	public String randomSelection(){
		
		int aiRow=0, aiColumn=0;
		aiRow = (int)(Math.random()*8); //selects values between 1 and 8, otherwise out of bounds
		aiColumn = 65+(int)(Math.random()*8); //selects values between A and H, otherwise out of bounds
		String coordinates = ((char)aiColumn)+""+(aiRow+1); //correct representation of coordinates
		return coordinates;
	}

	/**
	 * Checks whether the coordinates supplied by the user are valid, and prints the appropriate responses
	 * if not.
	 * @param coordinates an object of type String
	 * @return a boolean value
	 */
	public boolean humanCheckCoordinates(String coordinates){

		if (coordinates.charAt(0)<'A'||coordinates.charAt(0)>'H'||
				coordinates.charAt(1)<'1'||coordinates.charAt(1)>'8')
		{
			System.out.print("\tPosition out of bounds. Try again.\n");
			return false;
		}
		else if (battleField[coordinates.charAt(1)-'1'][coordinates.charAt(0)-'A']!=null&&!setUp)
		{
			System.out.print("\tPosition already taken. Try again.\n");
			return false;
		}
		else if(setUp&&battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].getIsCalled())
		{
			System.out.println("\tPosition already called. Try again.");
			return false;
		}
		else return true;
	}
	
	/**
	 * Checks whether the coordinates randomly selected by the computer are valid.
	 * @param coordinates an object of type String
	 * @return a boolean value
	 */
	public boolean computerCheckCoordinates(String coordinates){
		
		if (coordinates.charAt(0)<'A'||coordinates.charAt(0)>'H'||
				coordinates.charAt(1)<'1'||coordinates.charAt(1)>'8')
			return false;
		else if (battleField[coordinates.charAt(1)-'1'][coordinates.charAt(0)-'A']!=null&&!setUp)
			return false;
		else if(setUp&&battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].getIsCalled())
			return false;
		else return true;
	}

	/**
	 * Initializes the rest of the array after players place their ships and grenades with objects of
	 * type Position.
	 */
	public void initialize(){
		
		setUp=true; //identifies that the placement of ships and grenades has ended
		for (int i=0;i<gridSize;i++)
			for(int j=0;j<gridSize;j++)
				if (battleField[i][j]==null) //if the position is empty (ie. no player ships or grenades)
					battleField[i][j]=new Position();
	}
	
	/**
	 * Initializes the rest of the array after players place their ships and grenades with objects of
	 * type Position.
	 */
	public void displayGrid(){
		
		for(int i=0;i<gridSize;i++)
		{
			for (int j=0;j<gridSize;j++)
				System.out.print(battleField[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Simulates the user's turn. Checks the validity of the coordinates of user rocket 
	 * -using the humanCheckCoordinates method- and then checks whether the object in that position is
	 * already owned and if it is, the type of that object.
	 * If a ship is present, it updates the counter on the ships, while if a grenade is present it will
	 * update the counter on the missed turns and ensures a missed turn.
	 * Displays the grid at the end of the turn -using the displayGrid method-.
	 * @see <a href="Battleship.html#humanCheckCoordinates-java.lang.String-">humanCheckCoordinates</a>
	 * @see <a href="Battleship.html#displayGrid-java.lang.String-">displayGrid</a>
	 */
	public void userTurn(){
		
		if(humanGrenade) //checks whether the user hit a grenade in the previous turn
		{
			boolean loop=false;
			while (!loop)
			{
				System.out.print("Enter the coordinates of your rocket: ");
				rCoords=myKeyboard.next().toUpperCase();
				if(humanCheckCoordinates(rCoords))
				{
					battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].rocketFire();
					if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].getIsOwned())
					{
						if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
								getType().equalsIgnoreCase("s"))
						{
							if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
									getOwner().equals("H"))
								humanShips--;
							if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
									getOwner().equals("C"))
								computerShips--; //computer ships counter
						}
						else 
						{
							humanGrenade=false; //if user hits a grenade
							humanMissedTurns++; //missed turns counter
						}
					}
					loop=true;
				}
			}
			displayGrid();
		}
		else humanGrenade=true; //after a missed turn
	}
	
	/**
	 * Simulates the computers's -turn using the randomSelection- checks the validity of the coordinates
	 * of computer rocket -using the computerCheckCoordinates method- and then checks whether the object 
	 * in that position is already owned and if it is, the type of that object.
	 * If a ship is present, it updates the counter on the ships, while if a grenade is present it will
	 * update the counter on the missed turns and ensures a missed turn.
	 * Displays the grid at the end of the turn -using the displayGrid method-.
	 * @see <a href="Battleship.html#computerCheckCoordinates-java.lang.String-">computer
	 * CheckCoordinates</a>
	 * @see <a href="Battleship.html#randomSelection-java.lang.String-">randomSelection</a>
	 * @see <a href="Battleship.html#displayGrid-java.lang.String-">displayGrid</a>
	 */
	public void computerTurn(){

		if(computerGrenade)
		{
			boolean loop=false;
			System.out.print("Coordinates of my rocket: ");
			while(!loop)
			{
				rCoords=randomSelection();
				if(computerCheckCoordinates(rCoords))
				{
					System.out.println(rCoords);
					battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].rocketFire();
					if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].getIsOwned())
					{
						if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
								getType().equalsIgnoreCase("s"))
						{
							if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
									getOwner().equals("H"))
								humanShips--;
							if(battleField[rCoords.charAt(1)-'1'][rCoords.charAt(0)-'A'].
									getOwner().equals("C"))
								computerShips--;
						}
						else
						{
							computerGrenade=false;
							computerMissedTurns++;
						}
					}
					loop=true;
				}
			}
			displayGrid();
		}
		else computerGrenade=true;
	}
	
	/**
	 * Checks the number of ships for both players at the end of each turn to check if the game if all
	 * ships have been destroy to end the game.
	 * Displays the number of missed turns in the case of game end.
	 */
	public void gameEnd(){
		if(humanShips==0)
		{
			System.out.println("------------------------GAME OVER------------------------\n");
			System.out.println("Player Missed Turns: "+humanMissedTurns);
			System.out.println("Computer Missed Turns: "+computerMissedTurns+"\n");
			System.out.println("You lose! Better luck next time!");
			game=false; //ends the game
		}
		if(computerShips==0)
		{
			System.out.println("------------------------GAME OVER------------------------\n");
			System.out.println("Player Missed Turns: "+humanMissedTurns);
			System.out.println("Computer Missed Turns: "+computerMissedTurns+"\n");
			System.out.println("You win! Congratulations!");
			game=false;
		}
	}
	
	/**
	 * Runs the game of battleship by placing the user army -using the humanPlace method- and placing the
	 * computer army -using the computerPlace method-. Initializes the rest of the array -using the
	 * initialize method- and displays the grid for the start of the game -using the displayGrid method-.
	 * @see <a href="Battleship.html#humanPlace-java.lang.String-">humanPlace</a>
	 * @see <a href="Battleship.html#computerPlace-java.lang.String-">computerPlace</a>
	 * @see <a href="Battleship.html#initialize-java.lang.String-">initialize</a>
	 * @see <a href="Battleship.html#displayGrid-java.lang.String-">displayGrid</a>
	 */
	public void runGame(){
		
		boolean humanGrenade=true, computerGrenade=true;
		System.out.println("Welcome to Battleship! Let's play..\n");
		humanPlace();
		computerPlace();
		initialize();
		displayGrid();
		
		while(game) //loops the game until all ships have been destroyed
		{
			
			userTurn();
			if(computerShips==0||humanShips==0)
			{
				gameEnd();
				break;
			}
			computerTurn();
			if(computerShips==0||humanShips==0)
			{
				gameEnd();
				break;
			}
		}	
	}
}

