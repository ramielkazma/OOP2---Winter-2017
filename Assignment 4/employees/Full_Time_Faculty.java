package employees;

public class Full_Time_Faculty extends Employee {

	private double salary;
	
	public Full_Time_Faculty(){
		super();
	}

	public Full_Time_Faculty(long employeeID, String firstName, String lastName, String cityOfResidence, 
			int hireYear, double salary) {
		super(employeeID, firstName, lastName, cityOfResidence, hireYear);
		this.salary = salary;
	}
	
	public Full_Time_Faculty(Full_Time_Faculty ftf1){
		super(ftf1);
		salary = ftf1.salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Full_Time_Faculty clone(){
		return (new Full_Time_Faculty(this));
	}
	
	public String toString() {
		return (""+employeeID+" "+firstName+"\t"+formatToString(lastName)+formatToString(cityOfResidence)+
				hireYear+"\t"+salary);
	}
	
	//formats String to print in text file
	private String formatToString(String s){
		String str = s+"\t";
		if(s.length()<8)
			str+="\t";
		return str;
	}
	
	public boolean equals(Object obj) {
		if(this==null||obj==null||this.getClass()!=obj.getClass())
			return false;
		else
		{
			Full_Time_Faculty ftf1 = (Full_Time_Faculty) obj;
			return(employeeID==ftf1.employeeID && firstName.equals(ftf1.firstName) && lastName.equals(ftf1.lastName) 
					&& cityOfResidence.equals(ftf1.cityOfResidence) && hireYear==ftf1.hireYear && salary==ftf1.salary);		
		}
	}	
}
