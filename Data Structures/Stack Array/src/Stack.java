import java.util.Scanner;

// Create a class Stack consisting of main method in it
public class Stack {

	// Declare Global Variables
	static int max = 5 , top = -1 ;
	static int[] stack = new int[max];
	static int data = 0 ;
	
	public static void main(String[] args) {
		
		// Create Scanner class object
		Scanner sc = new Scanner(System.in);
		
		// Get user input data again and again
		do {
			System.out.print("Enter the data : ");
			data = sc.nextInt();
			
			push(data); // Push the data into the stack
			
			System.out.print("Do you want to add more (y/n) : ");
			
		}while(sc.next().equals("y"));
	
		// Show the stack data : 
		System.out.print("Stack : ");
		showData();
		
		// Pop the top element out of the stack
		System.out.print("Poping one element out : ");
		pop();
		showData();
		
		// Show the top element of the stack
		peek();
	}
	
	// Create static function push() so that it can be accessed in the static main method
	public static void push(int data) {
		
		// Check if stack is full
		if(top == max-1) {
			System.out.println("Stack is Full");
		}else { // Else push the data
			top++ ;
			stack[top] = data ;
		}
		
	}
	
	// Function to delete the top element in the stack
	public static void pop() {
		
		// Check if stack is empty
		if(top == 0) {
			System.out.println("Stack Empty");
		}else { // Else pop the data
			stack[top] = 0  ;
			top-- ; 
		}
		
	}
	
	// Function to delete the top element in the stack
	public static void peek() {
		
		// Check if stack is empty
		if(top == 0) {
			System.out.println("Stack Empty");
		}else { // Else print the top element of the stack
			System.out.println("Top Element : " + stack[top]);
		}
		
	}	
	
	// Function to show the data of the stack
	public static void showData() {
		for (int i = 0; i < top; i++) { // Traverse until top
			System.out.print(stack[i] + "-->");
		}
		System.out.println(stack[top]);
	}
	
}
