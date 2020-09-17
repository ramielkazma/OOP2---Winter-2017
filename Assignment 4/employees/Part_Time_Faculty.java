package employees;

public class Part_Time_Faculty extends Employee {

	private double hourlyRate;
	private int hours;
	private int students;
	
	public Part_Time_Faculty(){
		super();
	}

	public Part_Time_Faculty(long employeeID, String firstName, String lastName, String cityOfResidence, 
			int hireYear, double hourlyRate, int hours, int students) {
		super(employeeID, firstName, lastName, cityOfResidence, hireYear);
		this.hourlyRate = hourlyRate;
		this.hours = hours;
		this.students = students;
	}
	
	public Part_Time_Faculty(Part_Time_Faculty ptf1){
		super(ptf1);
		hourlyRate = ptf1.hourlyRate;
		hours = ptf1.hours;
		students = ptf1.students;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}
	
	public double calculateSalary(){
		double salary = hourlyRate*hours;
		if(students >= 40 && students <= 60)
			salary += 500;
		else
			if(students > 60)
				salary += 1000;
		return salary;
	}
	
	public Part_Time_Faculty clone(){
		return (new Part_Time_Faculty(this));
	}

	public String toString() {
		return (""+employeeID+" "+firstName+"\t"+formatToString(lastName)+formatToString(cityOfResidence)+hireYear
				+"\t"+hourlyRate+"\t"+hours+"\t"+students);
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
			Part_Time_Faculty ptf1 = (Part_Time_Faculty) obj;
			return(employeeID==ptf1.employeeID && firstName.equals(ptf1.firstName) && lastName.equals(ptf1.lastName) 
					&& cityOfResidence.equals(ptf1.cityOfResidence) && hireYear==ptf1.hireYear && 
					hourlyRate==ptf1.hourlyRate && hours==ptf1.hours && students==ptf1.students);
		}
	}
	
}
