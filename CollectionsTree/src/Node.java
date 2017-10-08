class Node{
	
	private int data ; 
	private Node right ;
	private Node left ; 
	 
	public Node() { 
		data = 0 ;
		right = null ;
		left = null ;
	}
	
	public Node(int d) {
		data = d ;
	}
	
	public void setRightLink(Node link) {
		right = link ;
	}
	
	public void setLeftLink(Node link) {
		left = link ;
	}
	
	public Node getRightLink() {
		return right ;
	}
	
	public Node getLeftLink() {
		return left ;
	}
	
	public int getData() {
		return data ;
	}
	
}