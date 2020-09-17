package employees;

public class Staff extends Employee{

	private double salary;
	private char performanceCode;
	
	public Staff(){
		super();
	}

	public Staff(long employeeID, String firstName, String lastName, String cityOfResidence, int hireYear, double salary, 
			char performanceCode) {
		super(employeeID, firstName, lastName, cityOfResidence, hireYear);
		this.salary = salary;
		this.performanceCode = performanceCode;
	}
	
	public Staff(Staff s1){
		super(s1);
		salary = s1.salary;
		performanceCode = s1.performanceCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public char getPerformanceCode() {
		return performanceCode;
	}

	public void setPerformanceCode(char performanceCode) {
		this.performanceCode = performanceCode;
	}
	
	public void calculateSalary(){
		int percentage = 0;
		switch(performanceCode)
		{
			case 'A': percentage = 8;
				break;
			case 'B': percentage = 6;
				break;
			case 'C': percentage = 3;
				break;
			case 'D': percentage = 1;
				break;
			case 'E': break; 
		}
		salary = salary + salary*percentage/100;
		performanceCode = 'E';
	}
	
	public Staff clone(){
		return (new Staff(this));
	}

	public String toString() {
		return (""+employeeID+" "+firstName+"\t"+formatToString(lastName)+formatToString(cityOfResidence)+hireYear
				+"\t"+salary+"\t\t"+performanceCode);
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
			Staff s1 = (Staff) obj;
			return(employeeID==s1.employeeID && firstName.equals(s1.firstName) && lastName.equals(s1.lastName) 
					&& cityOfResidence.equals(s1.cityOfResidence) && hireYear==s1.hireYear && salary==s1.salary &&
					performanceCode==s1.performanceCode);		
		}
	}
	
	
	
}
