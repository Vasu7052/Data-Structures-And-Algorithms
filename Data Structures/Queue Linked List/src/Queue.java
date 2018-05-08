import java.util.Scanner;

//class for creating linked list
class LinkList{
	
	private Node start ;
	private Node end ;
	public int front ;
	public int rear ;
	public int max ;
	
	// Initialize all the variables
	public LinkList() {
		start = null ;
		end = null ;
		front = -1 ;
		rear = -1 ;
		max = 5 ;
	}
	
	// Adding nodes at last of the queue (Made up of linked list)
	public void addAtEnd(int data) {
		Node node = new Node(data , null); // Create object of Node class
		
		// Check if queue is Full
		if(rear == max -1) {
			System.out.println("Queue is Full");
		}else if(front == -1 && rear == -1){
			
			front++ ; // Increment front by one
			rear++ ; // Increment rear by one
			start = node ; // make node the starting node
			end = start ;  // make node the ending node
			
		}else {
			
			rear++ ;
			end.setLink(node);  // Attach new node after end
			end = node ; // make the new node as end 
		
		}
	}
	
	// Deleting node in linked list
	public void deleteNode() {
		
		// Check if queue is empty
		if(rear == -1) {
			System.out.println("Empty Queue");
		}else {
		Node ptr = start ;
		start = start.getLink();
		ptr = null ;
		front++ ;
		}
		
	}
	
	// Function to show last element of the queue
	public void showLastElement() {
		
		// Check if queue is empty
		if(rear == -1) {
			System.out.println("Empty Queue");
		}else {
		System.out.println(end.getData());
		}
	}
	
	// Function to show data of the queue
	public void showData() {
		
		if(start == null) {
			System.out.println("No data");
		}else { // Traverse through end of the queue and delete the last node of the queue      
		
		Node ptr = start ;
		
		while(ptr.getLink() != null) {
			System.out.print(ptr.getData() + "--->");
			ptr = ptr.getLink();
		}
		
		System.out.print(ptr.getData());
		
		}
		
	}
	
}

public class Queue {

	public static void main(String[] args) {
		
		int data ;
		LinkList ll = new LinkList();
		
		// Create Scanner class object
		Scanner sc = new Scanner(System.in);
					
		// Get user input data again and again
		do {
			System.out.print("Enter the data : ");
			data = sc.nextInt();
						
			ll.addAtEnd(data); // Push the data into the queue
						
			System.out.print("Do you want to add more (y/n) : ");
						
			}while(sc.next().equals("y"));

		// Show the queue data : 
		System.out.println("Queue : ");
		ll.showData();
		
		// Remove the first element out of the queue (FIFO Mechanism)
		System.out.println("\nQueue after removing one element out : ");
		ll.deleteNode();
		ll.showData();
		
		// Show last element of the queue
		System.out.print("\nLast Element : ");
		ll.showLastElement();
		
	}
	
}
