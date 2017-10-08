
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