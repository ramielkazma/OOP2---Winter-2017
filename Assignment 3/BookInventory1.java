// ---------------------------------------------
// Assignment 3
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// March 14, 2017
// ---------------------------------------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookInventory1 {

	static Book[] bkArray; //these variables are static for the class
	static int counter;    //as they are used by all methods
	
	public static void fixInventory(PrintWriter pw, Scanner sc){
		
		long isbn;
		int issueYear;
		String author;
		String title;
		double price;
		int numberPages;
		
		bkArray = new Book[counter];
		
		//fills Book attributes from the file records and creates Book objects to store in bkArray
		for(int i=0; i<bkArray.length;i++)
		{
			isbn=sc.nextLong();
			title=sc.next();
			issueYear=sc.nextInt();
			author=sc.next();
			price=sc.nextDouble();
			numberPages=sc.nextInt();
			bkArray[i]=new Book(isbn, issueYear, author, title, price, numberPages);
		}
		
		detectISBN();                       //detects duplicate ISBN values
		for(int i=0;i<bkArray.length;i++)   //stores fixed duplicate ISBN values in a new file
			pw.println(bkArray[i]);
			
	}
	
	public static void displayFileContents(Scanner sc){

		while(sc.hasNextLine())                  //there is still information to be read in the file
			System.out.println(sc.nextLine());
	}
	
	private static void counter(Scanner sc){
		
		System.out.println("Detecting number of records in file....");

		while (sc.hasNextLine()) //condition is true when information from the file can still be read
		{
			sc.nextLine();
			counter++;       //counts the records
		}
		System.out.println("There are "+counter+" records in the file.\n");
	}
	
	private static void detectISBN(){
		
		boolean loop=true;
		long isbn=0;
		Scanner kb = new Scanner(System.in);
		
		for (int i=0; i<bkArray.length-1;i++)           //ISBN value to compare
		{
			//checks array for duplicate ISBN values
			//will change the value at index j+1 if it is the same as value at index i
			for(int j=i+1; j<bkArray.length;j++)        
				if (bkArray[i].getIsbn()==bkArray[j].getIsbn())
				{
					loop=true;
					while(loop) //this condition is satisfied when the user has selected a duplicate ISBN
					{
						System.out.print("Duplicate ISBN "+bkArray[i].getIsbn()+" detected in entry in"
								+ " record #"+(j+1)+". Please enter the correct ISBN: ");
						isbn=kb.nextLong();
						for(int k=0;k<bkArray.length;k++)
						{
							try
							{
								if(isbn==bkArray[k].getIsbn())
									throw new DuplicateISBNException();
								
							}
							catch(DuplicateISBNException e)
							{
								System.out.println(e.getMessage());
								System.out.println("Initial appearance of ISBN "+isbn+" was found at"
										+ " record #"+(k+1)+".");
								System.out.println("Error.... Duplicate entry of ISBN. The entered ISBN"
										+ " exists for another record.");
								break;  //no need to continue searching through array for other duplicates
										//as we have already found one
							}
							//if done scanning array without finding a duplicate, we can exit the while loop
							if(k==bkArray.length-1)
								loop=false;
						}
					}
					bkArray[j].setIsbn(isbn); //change the ISBN value of the duplicate to the one the user
											  //entered after all conditions are satisfied.
				}
		}
		kb.close();
	}
	
	public static void main(String[] args) {
	
		Scanner kb=new Scanner(System.in);
		System.out.print("Please enter the name of the output file: ");
		String initial = "Initial_Book_Info.txt";
		String fileName = kb.nextLine();
		File file1 = new File(fileName);
		
		while(file1.exists()) //checks whether there exists another file with the same name
		{
			System.out.print("\nError: The filename already exists. Its size is: "+file1.length()+" bytes."
					+"\nPlease choose another one: " );
			fileName=kb.nextLine();
			file1 = new File(fileName);
		}
		
		PrintWriter pw = null;
		Scanner sc = null;
		
		
		try
		{
			System.out.println("\nAttempting to open file: "+initial);
			pw = new PrintWriter(new FileOutputStream(fileName));
			sc = new Scanner(new FileInputStream(initial));
			
			counter(sc);
			sc.close();
			
			sc = new Scanner(new FileInputStream(initial));
			fixInventory(pw,sc);
			
			pw.close();
			sc.close();
			
			sc = new Scanner(new FileInputStream(initial));
			System.out.println("\nHere are the records for "+initial+"\n"
					+ "==============================================");
			displayFileContents(sc);
			
			sc.close();
			
			sc = new Scanner(new FileInputStream(fileName));
			System.out.println("\nHere are the records for "+fileName+"\n"
					+ "================================================");
			displayFileContents(sc);
			
			sc.close();
			kb.close();
			
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
		
		System.out.println("=============================End of Program!=============================");
	}

}
