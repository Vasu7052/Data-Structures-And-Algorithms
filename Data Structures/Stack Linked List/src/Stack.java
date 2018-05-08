import java.util.Scanner;

//Create a node class for creating new nodes in linked list
class Node{
	
	private int data ;  // data of that node
	private Node next ; // node data of next linked node
	
	public Node() { // initialize new node
		data = 0 ;
		next = null ;
	}

	// Input data in new node
	public Node(int d , Node n) {
		data = d ;
		next = n ;
	}
	
	// set link to the next node
	public void setLink(Node link) {
		next = link ;
	}
	
	// Get link to the next node
	public Node getLink() {
		return next ;
	}
	
	// Get data of the current node
	public int getData() {
		return data ;
	}
	
}

//class for creating linked list
class LinkList{
	
	private Node start ;
	private Node end ;
	public int top ;
	public int max ;
	
	// Initialize all the variables
	public LinkList() {
		start = null ;
		end = null ;
		top = -1 ;
		max = 5 ;
	}
	
	// Adding nodes at top of the stack (Made up of linked list)
	public void addAtEnd(int data) {
		Node node = new Node(data , null); // Create object of Node class
		
		if(top == max -1) {
			System.out.println("Stack is Full");
		}else if(top == -1){
			
			top++ ;
			start = node ; // make node the starting node
			end = start ;  // make node the ending node
			
		}else {
			
			top++ ; // Increment top
			end.setLink(node);  // Attach new node after end
			end = node ; // make the new node as end
		
		}
	}
	
	// Deleting node in linked list
	public void deleteNode() {
		
		// Check if stack is empty
		if(top == -1) {
			System.out.println("Empty Stack");
		}else if(top == 0){
			start = null ;
			top-- ;
		}else{ // Traverse through end of the stack and delete the top node of the stack
		
		Node preptr = start ;
		Node ptr = start ;
		ptr = ptr.getLink();
		
		while(ptr.getLink() != null) {
			preptr = preptr.getLink();
			ptr = ptr.getLink();
		}
		
		ptr = null ;
		preptr.setLink(null);
		end = preptr ;
		top-- ; // Reduce the top by one
		
		}
		
	}
	
	// Function to show top element of the stack
	public void showTopElement() {
		
		// Check if stack is empty
		if(top == -1) {
			System.out.println("Empty Stack");
		}else {
		System.out.println(end.getData()); // The The end node data
		}
	}
	
	// Function to show data of the stack
	public void showData() {
		
		// Check if stack is empty
		if(start == null) {
			System.out.println("No data");
		}else {
		
		// Start traversing from start and go to end
		Node ptr = start ;
		
		while(ptr.getLink() != null) {
			System.out.print(ptr.getData() + "--->");
			ptr = ptr.getLink();
		}
		
		System.out.print(ptr.getData());
		
		}
		
	}
	
}

public class Stack {

	public static void main(String[] args) {
		
		int data ;
		LinkList ll = new LinkList(); // Create object of linked list class
		
		// Create Scanner class object
		Scanner sc = new Scanner(System.in);
				
		// Get user input data again and again
		do {
			System.out.print("Enter the data : ");
			data = sc.nextInt();
					
			ll.addAtEnd(data); // Push the data into the stack
					
			System.out.print("Do you want to add more (y/n) : ");
					
			}while(sc.next().equals("y"));
		
		// Show the Stack
		System.out.println("Stack : ");
		ll.showData();
		
		// Pop out top element from the stack
		System.out.println("\nStack after poping : ");
		ll.deleteNode();
		ll.showData();
		
		// Print the top element of the stack
		System.out.print("\nTop Element : ");
		ll.showTopElement();
		
	}
	
}
