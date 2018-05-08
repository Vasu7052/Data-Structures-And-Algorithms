import java.util.Scanner;

// Create a node class for creating new nodes in linked list
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

// class for creating linked list
class LinkList{
	
	private Node start ;
	private Node end ;
	public int size ;
	
	// Initialize all the variables
	public LinkList() {
		start = null ;
		end = null ;
		size = 0 ;
	}
	
	// Adding nodes at starting of the linked list
	public void addAtStart(int data) {
		
		Node node = new Node(data , null);  // Create object of Node class
		size++ ;
		
		if(start == null) {
			
			start = node ; // make node the starting node
			end = start ;  // make node the ending node
			
		}else {
			
		node.setLink(start); // Attach new node before start
		start = node ;  // make the new node as start
		
		}
		
	}
	
	// Adding node at end of the linked list
	public void addAtEnd(int data) {
		Node node = new Node(data , null);
		size++ ;
		
		if(start == null) {
			
			start = node ;
			end = start ;
			
		}else {
			
		end.setLink(node); // Attach new node after end
		end = node ;       // make the new node as end
		
		}
	}
	
	// Adding node at the middle of the linked list
	public void addAtMiddle(int data , int pos) {
		Node node = new Node(data , null);
		size++ ;
		
		Node preptr = start ;
		Node ptr = start ;
		ptr = ptr.getLink();
		int count = 1 ;
		while(count != pos) {
			preptr = preptr.getLink();
			ptr = ptr.getLink();
			count++ ;
		}
		preptr.setLink(node);
		node.setLink(ptr);
		
	}
	
	// Adding node after a certain data of the linked list
	public void addAfterData(int data , int refData) {
		Node node = new Node(data , null);
		size++ ;
		
		
		Node preptr = start ;
		Node ptr = start ;
		ptr = ptr.getLink();
		
		while(preptr.getData() != refData) {
			preptr = preptr.getLink();
			ptr = ptr.getLink();
		}
		preptr.setLink(node);
		node.setLink(ptr);
		
	}
	
	// Deleting node in linked list
	public void deleteNode(int refData) {
		
		Node preptr = start ;
		Node ptr = start ;
		ptr = ptr.getLink();
		
		while(ptr.getData() != refData) {
			preptr = preptr.getLink();
			ptr = ptr.getLink();
		}
		
		preptr.setLink(ptr.getLink());
		ptr = null ;
		
		size-- ;
		
	}
	
	// Traversing through linked list and showing data
	public void showData() {
		
		if(start == null) {
			System.out.println("No data");
		}else {
		
		Node ptr = start ;
		
		while(ptr.getLink() != null) {
			System.out.print(ptr.getData() + "--->");
			ptr = ptr.getLink();
		}
		
		System.out.print(ptr.getData());
		
		}
		
	}
	
}

public class SingleLinkedList {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int data = 0  ;
		
		LinkList ll = new LinkList();
		
		System.out.println("Choose : \n1. Insert at Start \n2. Insert At End \n3. Use already linklist");
		
		switch (sc.nextInt()) {
		case 1:
			
			do {
				System.out.print("Enter the data : ");
				data = sc.nextInt();
				
				ll.addAtStart(data);
				
				System.out.print("Do you want to add more (y/n) : ");
				
			}while(sc.next().equals("y"));
			
			ll.showData();
			
			break;
			
		case 2:
			
			do {
				System.out.print("Enter the data : ");
				data = sc.nextInt();
				
				ll.addAtEnd(data);
				
				System.out.print("Do you want to add more (y/n) : ");
				
			}while(sc.next().equals("y"));
			
			ll.showData();
			
			break;
			
		case 3 : 
			
			ll.addAtEnd(5);
			ll.addAtEnd(10);
			ll.addAtEnd(15);
			ll.addAtEnd(20);
			ll.addAtEnd(25);
			ll.showData();
			
			break ;

		default:
			break;
		}
		
		System.out.println("\nChoose : \n1. Insert At Middle \n2. Insert After A Data \n3. Delete A Node");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.print("Enter the data : ");
			data = sc.nextInt();
			int pos = 0 ;
			if(ll.size%2 == 0) {
				pos = ll.size/2 ;
			}else {
				pos = (ll.size - 1)/2 ;
			}
			ll.addAtMiddle(data , pos);
			
			ll.showData();
			
			break;
		case 2:
			System.out.print("Enter the data : ");
			data = sc.nextInt();
			
			System.out.print("Enter the data after which you want to add new data : ");
			
			ll.addAfterData(data , sc.nextInt());
			
			ll.showData();
			break;
		case 3:
			System.out.print("Enter the data to be deleted : ");
			data = sc.nextInt();
			
			ll.deleteNode(data);
			
			ll.showData();
			break;

		default:
			break;
		}
		
		
	}

}
