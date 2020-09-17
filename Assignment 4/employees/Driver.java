package employees;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

	static ArrayList<Full_Time_Faculty> ftRecords;
	static ArrayList<Part_Time_Faculty> ptRecords;
	static ArrayList<TA> taRecords;
	
	public static void main(String[] args) {
		System.out.println("==========================================Start======================"
				+ "====================\n");
		
		fillFTRecords(openInput("Full-Time-Faculty.txt"));
		fillPTRecords(openInput("Part-Time-Faculty.txt"));
		fillTARecords(openInput("TAs.txt"));
		
		System.out.println("Please follow the instructions to add a record for a FULL-TIME employee.\n");
		addFTRecords();
		System.out.println("\nPlease follow the instructions to add a record for a PART-TIME employee.\n");
		addPTRecords();
		System.out.println("\nPlease follow the instructions to add a record for a TA.\n");
		addTARecords();
		
		System.out.println("\nYour request for the combined term salary for TAs and Part-Time Employees is successful."+
				"\nThe term salary is: $" + findTermSalary());
		
		increase_Staff_Salary();
		findHighest_and_Lowest_FT_Salary();
		
		TA ta = new TA();
		Full_Time_Faculty ftf = new Full_Time_Faculty(9999999, "Rami", "El-Kazma", 
				"Montreal", 2017, 80000);
		System.out.println("\nftf precedes ta: "+ftf.precedes(ta)+"\t"+"ftf follows ta: "+ftf.follows(ta));
		System.out.println("ta precedes ftf: "+ta.precedes(ftf)+"\t"+"ta follows ftf: "+ta.follows(ftf));
		
		System.out.println("\n==========================================End of Program======================"
				+ "====================");
	}
	
	//method to open output streams and checking for exceptions
	private static PrintWriter openOutput(String s){
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new FileOutputStream(s));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
		return pw;
	}
	
	//method to open input streams and checking for exceptions
	private static Scanner openInput(String s){
		Scanner sc = null;
		try
		{
			sc = new Scanner(new FileInputStream(s));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
		return sc;
	}
	
	//adds values to the array list
	private static void fillFTRecords(Scanner sc){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double salary;
		ftRecords = new ArrayList<Full_Time_Faculty>(8);
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			salary = sc.nextDouble();
			Full_Time_Faculty ftf = new Full_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
					hireYear, salary);
			ftRecords.add(ftf);
		}
		sc.close();
	}
	
	public static void addFTRecords(){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double salary;
		Scanner kb = null;

		while(employeeID!=-1)
		{
			kb = new Scanner(System.in);
			boolean duplicate = true;
			System.out.print("Please enter an ID if you wish to enter a record. Enter \"-1\" to exit: ");
			try //if for example a string is entered in place of a long, the entries will be deleted and user will repeat
			{
				while(duplicate) //if duplicate is true, the ID entered is already taken
				{
					employeeID = kb.nextLong();
					if(employeeID==-1)
						return;
					if(searchArrayList(employeeID))
					{
						System.out.print("ERROR: The ID you have entered is a duplicate. Please enter another one: ");
					}
					else duplicate = false;	//ID is not a duplicate
				}
				System.out.print("\nEmployee ID: "+employeeID);
				System.out.print("\nFirst Name: "); firstName = kb.next();
				System.out.print("Last Name: "); lastName = kb.next();
				System.out.print("City of Residence: ");cityOfResidence = kb.next();
				System.out.print("Year Hired: "); hireYear = kb.nextInt();
				System.out.print("Salary: $"); salary = kb.nextDouble();
				System.out.println();
				Full_Time_Faculty ftf = new Full_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
						hireYear, salary);
				ftRecords.add(ftf);
			}
			catch(InputMismatchException e)
			{
				System.out.println("You have entered an invalid value for the required information. Please repeat "
						+ "your selections.\n");
				continue; //another iteration of the loop so the user can reenter information
			}

			//write the records back to the text file
			PrintWriter pw = openOutput("Full-Time-Faculty.txt");
			for(int i = 0; i<ftRecords.size()-1;i++)
				pw.println(ftRecords.get(i));
			pw.print(ftRecords.get(ftRecords.size()-1));
			pw.close();
		}
	}
	
	private static void fillPTRecords(Scanner sc){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double hourlyRate;
		int hours; int students;
		ptRecords = new ArrayList<Part_Time_Faculty>(8);
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			hourlyRate = sc.nextDouble();
			hours = sc.nextInt();
			students = sc.nextInt();
			Part_Time_Faculty ptf = new Part_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
					hireYear, hourlyRate, hours, students);
			ptRecords.add(ptf);
		}
		sc.close();
		
	}
		
	public static void addPTRecords(){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double hourlyRate;
		int hours; int students;
		Scanner kb = null;
		while(employeeID!=-1)
		{
			kb = new Scanner(System.in);
			boolean duplicate = true;
			System.out.print("Please enter an ID if you wish to enter a record. Enter \"-1\" to exit: ");
			try
			{
				while(duplicate)
				{
					employeeID = kb.nextLong();
					if(employeeID==-1)
						return;
					if(searchArrayList(employeeID))
					{
						System.out.print("ERROR: The ID you have entered is a duplicate. Please enter another one: ");
					}
					else duplicate = false;	
				}
				System.out.print("\nEmployee ID: "+employeeID);
				System.out.print("\nFirst Name: "); firstName = kb.next();
				System.out.print("Last Name: "); lastName = kb.next();
				System.out.print("City of Residence: ");cityOfResidence = kb.next();
				System.out.print("Year Hired: "); hireYear = kb.nextInt();
				System.out.print("Hourly Rate: $"); hourlyRate = kb.nextDouble();
				System.out.print("Number of Hours: "); hours = kb.nextInt();
				System.out.print("Number of Students: "); students = kb.nextInt();
				System.out.println();
				Part_Time_Faculty ptf = new Part_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
						hireYear, hourlyRate, hours, students);
				ptRecords.add(ptf);
			}
			catch(InputMismatchException e)
			{
				System.out.println("You have entered an invalid value for the required information. Please repeat "
						+ "your selections.\n");
				continue;
			}
			
			PrintWriter pw = openOutput("Part-Time-Faculty.txt");
			for(int i = 0; i<ptRecords.size()-1;i++)
				pw.println(ptRecords.get(i));
			pw.print(ptRecords.get(ptRecords.size()-1));
			pw.close();
		}
	}
	
	private static void fillTARecords(Scanner sc){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; 
		String classification; int classes; int workingHours;
		taRecords = new ArrayList<TA>(8);
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			classification = sc.next();
			if(!(classification.equalsIgnoreCase("ugrad") ||classification.equalsIgnoreCase("grad")))
			{
				sc.nextLine();
				continue;
			}
			classes = sc.nextInt();
			workingHours = sc.nextInt();
			TA ta = new TA(employeeID, firstName, lastName, cityOfResidence, hireYear, 
					classification, classes, workingHours);
			taRecords.add(ta);
		}
		sc.close();
	}
	
	public static void addTARecords(){
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; 
		String classification; int classes; int workingHours;
		Scanner kb = null;
		while(employeeID!=-1)
		{
			kb = new Scanner(System.in);
			boolean duplicate = true;
			System.out.print("Please enter an ID if you wish to enter a record. Enter \"-1\" to exit: ");
			try
			{
				while(duplicate)
				{
					employeeID = kb.nextLong();
					if(employeeID==-1)
						return;
					if(searchArrayList(employeeID))
					{
						System.out.print("ERROR: The ID you have entered is a duplicate. Please enter another one: ");
					}
					else duplicate = false;	
				}
				System.out.print("\nEmployee ID: "+employeeID);
				System.out.print("\nFirst Name: "); firstName = kb.next();
				System.out.print("Last Name: "); lastName = kb.next();
				System.out.print("City of Residence: ");cityOfResidence = kb.next();
				System.out.print("Year Hired: "); hireYear = kb.nextInt();
				System.out.print("Classification: "); classification = kb.next();
				while(!(classification.equalsIgnoreCase("ugrad") ||classification.equalsIgnoreCase("grad")))
				{
					System.out.print("TA classification is invalid. Please try again: ");
					classification = kb.next();
				}
				System.out.print("Number of Classes: "); classes = kb.nextInt();
				System.out.print("Working Hours: "); workingHours = kb.nextInt();
				System.out.println();
				TA ta = new TA(employeeID, firstName, lastName, cityOfResidence, 
						hireYear, classification, classes, workingHours);
				taRecords.add(ta);
			}
			catch(InputMismatchException e)
			{
				System.out.println("You have entered an invalid value for the required information. Please repeat "
						+ "your selections.\n");
				continue;
			}
			
			PrintWriter pw = openOutput("TAs.txt");
			for(int i = 0; i<taRecords.size()-1;i++)
				pw.println(taRecords.get(i));
			pw.print(taRecords.get(taRecords.size()-1));
			pw.close();
		}
	}
	
	//method that checks if the ID entered is already used
	private static boolean searchArrayList(long employeeID){
		Employee employee;
		
		//checks all ArrayLists
		for(int i=0; i<ftRecords.size(); i++)
		{
			employee = ftRecords.get(i);
			if(employee.employeeID == employeeID)
				return true;
		}
		for(int i=0; i<ptRecords.size(); i++)
		{
			employee = ptRecords.get(i);
			if(employee.employeeID == employeeID)
				return true;
		}
		for(int i=0; i<taRecords.size(); i++)
		{
			employee = taRecords.get(i);
			if(employee.employeeID == employeeID)
				return true;
		}
		Scanner sc = openInput("Staff.txt");
		long id;
		while (sc.hasNextLine())
		{
			id = sc.nextLong();
			if(id == employeeID)
				return true;
			sc.nextLine();
		}
		return false;
	}
	
	public static double findTermSalary(){
		
		EmployeeList ptList = new EmployeeList();
		EmployeeList taList = new EmployeeList();
		
		Scanner sc = openInput("Part-Time-Faculty.txt");
		
		long employeeID; String firstName; String lastName; String cityOfResidence; int hireYear; 
		double hourlyRate; int hours; int students;
		
		//reading values into the linked list
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			hourlyRate = sc.nextDouble();
			hours = sc.nextInt();
			students = sc.nextInt();
			Part_Time_Faculty ptf = new Part_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
					hireYear, hourlyRate, hours, students);
			ptList.addAtEnd(ptf);
		}
		sc.close();

		String classification; int classes; int workingHours;
		Scanner sc2 = openInput("TAs.txt");
		while(sc2.hasNextLine())
		{
			employeeID = sc2.nextLong();
			firstName = sc2.next();
			lastName = sc2.next();
			cityOfResidence = sc2.next();
			hireYear = sc2.nextInt();
			classification = sc2.next();
			if(!(classification.equalsIgnoreCase("ugrad") ||classification.equalsIgnoreCase("grad")))
			{
				sc2.nextLine();
				continue;
			}
			classes = sc2.nextInt();
			workingHours = sc2.nextInt();
			TA ta = new TA(employeeID, firstName, lastName, cityOfResidence, hireYear, 
					classification, classes, workingHours);
			taList.addAtEnd(ta);
		}
		sc2.close();
		
		double termSalary = 0;
		for(int i=0; i<taList.size();i++)
		{
			TA ta = (TA)taList.returnAtIndex(i);
			termSalary += ta.calculateSalary();	//calculates salaries independently and sums them
		}
		
		for(int i=0; i<ptList.size();i++)
		{
			Part_Time_Faculty ptf = (Part_Time_Faculty)ptList.returnAtIndex(i);
			termSalary += ptf.calculateSalary();
		}
		return termSalary;
	}
	
	public static void findHighest_and_Lowest_FT_Salary(){
			
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double salary;
		
		Scanner sc = openInput("Full-Time-Faculty.txt");
		EmployeeList ftList = new EmployeeList();
		
		//adds values to the linked list
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			salary = sc.nextDouble();
			Full_Time_Faculty ftf = new Full_Time_Faculty(employeeID, firstName, lastName, cityOfResidence, 
					hireYear, salary);
			ftList.addAtEnd(ftf);
		}
		sc.close();
		
		double highestSalary = 0; //salaries cannot be lower than 0
		double lowestSalary;
		
		//iterates through the linked list and selects the highest salary
		for(int i=0; i<ftList.size();i++)
		{
			Full_Time_Faculty ftf = (Full_Time_Faculty)ftList.returnAtIndex(i);
			if(highestSalary < ftf.getSalary())
				highestSalary = ftf.getSalary();
		}
		System.out.println("\nThe employee(s) with the highest salary:");
		for(int i=0; i<ftList.size();i++) //checks if more than one employee has the same salary
		{
			Full_Time_Faculty ftf = (Full_Time_Faculty)ftList.returnAtIndex(i);
			if(highestSalary == ftf.getSalary())
				System.out.println("\t"+ftf);
		}
		
		lowestSalary = highestSalary; //all other salaries must be lower than the highestSalary
		for(int i=0; i<ftList.size();i++)
		{
			Full_Time_Faculty ftf = (Full_Time_Faculty)ftList.returnAtIndex(i);
			if(lowestSalary > ftf.getSalary())
				lowestSalary = ftf.getSalary();
		}
		System.out.println("The employee(s) with the lowest salary:");
		for(int i=0; i<ftList.size();i++)
		{
			Full_Time_Faculty ftf = (Full_Time_Faculty)ftList.returnAtIndex(i);
			if(lowestSalary == ftf.getSalary())
				System.out.println("\t"+ftf);
		}
		
	}
	
	public static void increase_Staff_Salary(){
		System.out.println("\nApplying performance-based salary raise for STAFF...");
		
		long employeeID=0; String firstName; String lastName; String cityOfResidence; int hireYear; double salary;
		char performanceCode;
		EmployeeList modifiedStaffList = new EmployeeList();

		Scanner sc = openInput("Staff.txt");
		EmployeeList staffList = new EmployeeList();
		while(sc.hasNextLine())
		{
			employeeID = sc.nextLong();
			firstName = sc.next();
			lastName = sc.next();
			cityOfResidence = sc.next();
			hireYear = sc.nextInt();
			salary = sc.nextDouble();
			performanceCode = sc.next().charAt(0);
			Staff staff = new Staff(employeeID, firstName, lastName, cityOfResidence, 
					hireYear, salary,performanceCode);
			staffList.addAtEnd(staff);
		}
		sc.close();
		
		for(int i=0; i<staffList.size();i++)
		{
			Staff staff = (Staff)staffList.returnAtIndex(i);
			staff.calculateSalary();
			modifiedStaffList.addAtEnd(staff); //corrected array
		}
		staffList = null; //clear unnecessary list
		
		//reenter information into the text file
		PrintWriter pw = openOutput("Staff.txt");
		for(int i = 0; i<modifiedStaffList.size()-1;i++)
			pw.println(modifiedStaffList.returnAtIndex(i));
		pw.print(modifiedStaffList.returnAtIndex(modifiedStaffList.size()-1));
		pw.close();
		System.out.println("Staff salaries have been modified.");
	}

}
	
