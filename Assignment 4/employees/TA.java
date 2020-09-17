package employees;

public class TA extends Employee {

	private String classification; 
	private int classes; 
	private int workingHours;
	
	public TA(){
		super();
	}

	public TA(long employeeID, String firstName, String lastName, String cityOfResidence, int hireYear, 
			String classification, int classes, int workingHours) {
		super(employeeID, firstName, lastName, cityOfResidence, hireYear);
		this.classification = classification;
		this.classes = classes;
		this.workingHours = workingHours;
	}
	
	public TA(TA ta1){
		super(ta1);
		classification = ta1.classification;
		classes = ta1.classes;
		workingHours = ta1.workingHours;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getClasses() {
		return classes;
	}

	public void setClasses(int classes) {
		this.classes = classes;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	
	public double calculateSalary(){
		double fixedRate = 18.25;
		if(classification.equalsIgnoreCase("grad"))
			return (1.2*fixedRate*workingHours);
		else return(fixedRate*workingHours);
	}
	
	public TA clone(){
		return (new TA(this));
	}

	public String toString() {
		return (""+employeeID+" "+firstName+"\t"+formatToString(lastName)+formatToString(cityOfResidence)+hireYear
				+"\t"+classification+"\t"+classes+"\t"+workingHours);
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
			TA ta1 = (TA) obj;
			return(employeeID==ta1.employeeID && firstName.equals(ta1.firstName) && lastName.equals(ta1.lastName) && 
					cityOfResidence.equals(ta1.cityOfResidence) && hireYear==ta1.hireYear &&
					classification.equals(ta1.classification) && classes==ta1.classes && 
					workingHours==ta1.workingHours);
				
		}
	}
	
}
