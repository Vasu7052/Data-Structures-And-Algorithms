


class LinkListCircular{
	
	private Node start ;
	private Node end ;
	public int front ;
	public int rear ;
	public int max ;
	
	public LinkListCircular() {
		start = null ;
		end = null ;
		front = -1 ;
		rear = -1 ;
		max = 5 ;
	}
	
	public void addAtEnd(int data) {
		Node node = new Node(data , null);
		
		if(rear == max -1 && front == 0 || rear == front-1) {
			System.out.println("\nQueue is Full");
		}else {
			
			if(front == -1 && rear == -1){
			
			front++ ;
			rear++ ;
			start = node ;
			end = start ;
			
		}else if(rear == max-1 && front != 0){
			rear = 0 ;
			end.setLink(node); 
			end = node ; 
		}else {
			
			rear++ ;
			end.setLink(node); 
			end = node ; 
		
			}
		}
	}
	
	public void deleteNode() {
		
		if(rear == -1) {
			System.out.println("Empty Queue");
		}else {
		Node ptr = start ;
		start = start.getLink();
		ptr = null ;
		front++ ;
		}
		
	}
	
	public void showTopElement() {
		
		if(rear == -1) {
			System.out.println("Empty Queue");
		}else {
		System.out.println(end.getData());
		}
	}
	
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

public class CircularQueue {

	public static void main(String[] args) {
		
		LinkListCircular ll = new LinkListCircular();
		
		ll.addAtEnd(5);
		ll.addAtEnd(10);
		ll.addAtEnd(15);
		ll.addAtEnd(20);
		ll.addAtEnd(25);
		System.out.println("Queue : ");
		ll.showData();
		System.out.println("\nQueue after removing 2 elements : ");
		ll.deleteNode();
		ll.deleteNode();
		ll.showData();
		System.out.print("\nLast Element : ");
		ll.showTopElement();
		ll.addAtEnd(30);
		ll.addAtEnd(35);
		System.out.print("New Queue : ");
		ll.showData();
		ll.addAtEnd(40);
		System.out.print("New Queue : ");
		ll.showData();
		
	}
	
}
