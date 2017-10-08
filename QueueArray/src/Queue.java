import java.util.Scanner;

// Create a class Queue consisting of main method in it
public class Queue {

	// Declare Global Variables
	static int front = -1 , rear = -1 , max = 5 ;
	static int[] queue = new int[max];
	static int data ;
	
	public static void main(String[] args) {
		
	// Create Scanner class object
	Scanner sc = new Scanner(System.in);
				
	// Get user input data again and again
	do {
		System.out.print("Enter the data : ");
		data = sc.nextInt();
					
		add(data); // Push the data into the queue
					
		System.out.print("Do you want to add more (y/n) : ");
					
		}while(sc.next().equals("y"));
		
		// Show the queue data : 
		System.out.print("Queue : ");
		showData();
		
		// Remove the first element out of the queue (FIFO Mechanism)
		System.out.print("\nRemoving one element out : ");
		delete();
		showData();
		
	}
	
	// Create static function add() so that it can be accessed in the static main method
	public static void add(int data) {
		
		// Check if queue is full
		if(rear == max-1) {
			System.out.println("Queue is Full");
		}else if(front == -1 && rear == -1) {
			front++ ; // Increment front by one
			rear++ ; // Increment rear by one
			queue[rear] = data ; // Add data to the queue at last of the queue
		}else {
			rear++ ; 
			queue[rear] = data ;
		}
	}
	
	public static void delete() {
		
		// Check if queue is empty
		if(front == -1 && rear == -1) {
			System.out.println("Empty Queue");
		}else {
			queue[front] = 0 ; // Remove element from front
			front++ ; // Increment front by one
		}
		
	}
	
	// Function to show the data of the queue
	public static void showData() {
		for (int i = front; i < rear; i++) {
			System.out.print(queue[i] + "-->");
		}
		System.out.println(queue[rear]);
	}
	
}
