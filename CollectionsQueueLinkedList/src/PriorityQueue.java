import java.util.Scanner;

//Create a PriorityNode class for creating new nodes in linked list
class PriorityNode{
	
	private String data ;  // data of that node
	private int priority ; // Priority of that node
	private PriorityNode next ; // node data of next linked node
	
	// initialize new node
	public PriorityNode() {
		data = null ;
		priority = 0 ;
		next = null ;
	}

	// Input data in new node
	public PriorityNode(String d , int p , PriorityNode n) {
		data = d ;
		priority = p ;
		next = n ;
	}
	
	// set link to the next node
	public void setLink(PriorityNode link) {
		next = link ;
	}
	
	// Get link to the next node
	public PriorityNode getLink() {
		return next ;
	}
	
	// Get data of the current node
	public String getData() {
		return data ;
	}
	
	// Get priority of the current node
	public int getPriority() {
		return priority ;
	}
	
}

//class for creating linked list
class LinkListPriority{
	
	
	private PriorityNode start ;
	
	// Initialize all the variables
	public LinkListPriority() {
		start = null ;
	}
	
	// Adding nodes according to their priority in the queue (Made up of linked list)
	public void add(String data , int p) {
		PriorityNode node = new PriorityNode(data , p , null);  // Create object of PriorityNode class
		
		PriorityNode p1 ;
		
		if(start == null || node.getPriority() < start.getPriority()) { // Adding first node or placing lower priority node after higher priority node
			node.setLink(start);
			start = node ;
		}else { // Placing nodes according to their priorities . Least at the last of the queue
			p1 = start ;
			while (p1.getLink() != null && node.getPriority() > p1.getLink().getPriority() && p1.getLink() != null ) {
				p1 = p1.getLink();
			}
			
			node.setLink(p1.getLink());
			p1.setLink(node);
			
		} 
	}
	
	// The node having higher priority will be deleted first
	public void deleteNode() {
		
		// Check if queue is Empty
		if(start == null) {
			System.out.println("Empty Queue");
		}else {
		PriorityNode ptr = start ;
		start = start.getLink();
		ptr = null ;
		}
		
	} 

	// Function to show data of the queue
	public void showData() {
		
		// Check if queue is Empty
		if(start == null) {
			System.out.println("No data");
		}else {
		
		PriorityNode ptr = start ;
		
		while(ptr.getLink() != null) {
			System.out.print(ptr.getData() + "[ P : " + ptr.getPriority() + "]" + "--->");
			ptr = ptr.getLink();
		}
		
		System.out.print(ptr.getData() + "[ P : " + ptr.getPriority() + "]");
		
		}
		
	}
	
}

public class PriorityQueue {

	public static void main(String[] args) {
		
		String data ;
		int priority ;
		LinkListPriority ll = new LinkListPriority();
		
		// Create Scanner class object
		Scanner sc = new Scanner(System.in);
							
		// Get user input data again and again
		do {
			System.out.print("Enter the data : ");
			data = sc.next();
			System.out.print("Enter the Priority : ");
			priority = sc.nextInt();
								
			ll.add(data,priority); // Push the data into the queue
								
			System.out.print("Do you want to add more (y/n) : ");
								
			}while(sc.next().equals("y"));
		
		// Show the data of the queue in priority order
		System.out.println("Queue : ");
		ll.showData();
		
		// Deleting data of the queue according to their priority
		System.out.println("\nQueue after deleting one element");
		ll.deleteNode();
		ll.showData();
		
	}
	
}
