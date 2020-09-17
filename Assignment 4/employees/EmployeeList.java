package employees;

public class EmployeeList {

	private class Node {

		private Employee e;
		private Node next;
 
		public Node()
		{
			e = null;
			next = null;
		}

		public Node(Employee e, Node n)
		{
			this.e = e;
			next = n;
		}
	} //end of Node class
	
	private Node head;
	
	public EmployeeList(){
		head = null;
	}
	
	//adds Employees at the end of a list
	public void addAtEnd(Employee e){
		
		Node t = head;
		if(head == null)
			head = new Node(e, null);
		
		else if(t.next==null)
			t.next = new Node(e,null);
		
		else
		{	
			while(t.next!=null)
				t = t.next;
			t.next = new Node(e,null);
		}
	}
	
	//calculates the amount of object in a linked list
	public int size(){
		int size = 0;
		if(head==null) //no elements
			return size;
		else //when there is one element
		{
			Node t = head;
			size++; //one element
				while(t.next!=null) //checks if there is more than one element
				{
					size++; //going into the loop would mean there is more than one element so we increment
					t = t.next;
				}	
			}		
			return size;
	}
	
	//returns the Employee at the given index
	//indices are the same format as in arrays (ie. the first element in the list is at index 0)
	public Employee returnAtIndex(int index){
		
		Employee employee;
		Node t = head;
		if(t==null)
			return null;
		for(int i=0; i<index;i++)
		{
			if(t.next == null)
				break;
			t = t.next;
		}
		employee = t.e.clone();
		return employee;
	}
	
}
