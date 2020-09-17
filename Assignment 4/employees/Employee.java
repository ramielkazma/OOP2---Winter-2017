package employees;

abstract class Employee {

	long employeeID;
	String firstName;
	String lastName;
	String cityOfResidence;
	int hireYear;
	
	public Employee(){
		
	}
	
	public Employee(long employeeID, String firstName, String lastName, String cityOfResidence, int hireYear)
	{
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cityOfResidence = cityOfResidence;
		this.hireYear = hireYear;
	}
	
	public Employee(Employee e1){
		employeeID = e1.employeeID;
		firstName = e1.firstName;
		lastName = e1.lastName;
		cityOfResidence = e1.cityOfResidence;
		hireYear = e1.hireYear;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(String cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public int getHireYear() {
		return hireYear;
	}

	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}
	
	public boolean precedes(Employee e){
		return(this.hireYear < e.hireYear);
	}

	public boolean follows(Employee e){
		return(this.hireYear > e.hireYear);
	}

	public abstract String toString();
	
	public abstract Employee clone();
	
	public abstract boolean equals(Object obj);
	
	
	
}
