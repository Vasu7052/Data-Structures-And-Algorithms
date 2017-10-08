import java.util.Scanner;


	class TreeStructure{
	
		static Node root ;
		public int size ;
		private String elements ; 
		
		public TreeStructure() {
			root = null ; 
			size = 0 ;
			elements = "" ;
		}
		
		public void add(int data) {
			
			Node node = new Node(data); 
			size++ ; 
			elements += node.getData() + " " ;
			Node ptr = root ;
			
			if(root == null) {
				root = node ;
			}else {
				insert(node , ptr) ;
			}
			
		}
		
		public void insert(Node node , Node ptr) {
			if(node.getData() < ptr.getData()) {
				if(ptr.getLeftLink() == null) {
					ptr.setLeftLink(node);
					ptr = node ;
				}else {
					ptr = ptr.getLeftLink();
					insert(node, ptr);
				}
				
			}else {
				if(ptr.getRightLink() == null) {
					ptr.setRightLink(node);
					ptr = node ;
				}else {
					ptr = ptr.getRightLink();
					insert(node, ptr);
				}
			}
			
		}
		
		public void printInorder(Node node) {
			
			if (node == null) 
	            return;
			
		        printInorder(node.getLeftLink());
		        
		        System.out.print(node.getData() + " ");
		 
		        printInorder(node.getRightLink());
		}
		
		public void printPostorder(Node node) {
			
			if (node == null) 
	            return;
			
		        printPostorder(node.getLeftLink());
		        printPostorder(node.getRightLink());
		        System.out.print(node.getData() + " ");
		}
		
		public void printPreorder(Node node) {
			
			if (node == null) 
	            return;
			
				System.out.print(node.getData() + " ");
		        printPreorder(node.getLeftLink());
		        printPreorder(node.getRightLink());
		}
		
		public String searchElement(int element) {
						
			if(elements.contains(String.valueOf(element))) {
				return "Element exists in the tree" ;
			}
			
			return "Element does not exists in the tree" ;
			
		}
		
		public int count(Node root) {
			
			if(root == null) {
				return 0 ;
			}
			
			return 1 + count(root.getLeftLink()) + count(root.getRightLink()) ;
			
		}
		
		public int sumOfNodes(Node root) {
			
			if(root == null) {
				return 0 ;
			}
			
			return root.getData() + sumOfNodes(root.getLeftLink()) + sumOfNodes(root.getRightLink()) ;
			
		}
		
		public int height(Node root) {
			if(root == null) {
				return 0 ;
			}
			
			int left = height(root.getLeftLink()) ;
			int right = height(root.getRightLink()) ;
			
			if(right >= left) {
				return right+1 ;
			}else
				return left+1 ;
		}
		
		public int diameter(Node root) {
			
			if(root == null) {
				return 0 ;
			}
			
			int leftH = height(root.getLeftLink());
			int rightH = height(root.getRightLink()) ;
			
			int leftDiameter = diameter(root.getLeftLink());
			int rightDiameter = diameter(root.getRightLink());
			
			return Math.max(leftH + rightDiameter + 1 , Math.max(leftDiameter , rightDiameter) ) ;
			
		}

	
	}


public class Tree {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TreeStructure ll = new TreeStructure();
		
		ll.add(10);
		ll.add(5);
		ll.add(2);
		ll.add(6);
		ll.add(4);
		ll.add(12);
		ll.add(18);
		ll.add(1);
		
		System.out.println("1. All 3 Traversals ");
		System.out.println("2. Insert an element ");
		System.out.println("3. Delete an Element ");
		System.out.println("4. Search an element in the tree ");
		System.out.println("5. Count the number of node ");
		System.out.println("6. Calculate Sum of all nodes ");
		System.out.println("7. Calculate height of the tree ");
		System.out.println("8. Calculate diameter of the tree ");
		
		do {
			
			System.out.print("\nEnter Your Option : ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Preorder : ");
				ll.printPreorder(TreeStructure.root);
				System.out.println("\nInorder : ");
				ll.printInorder(TreeStructure.root);
				System.out.println("\nPostorder : ");
				ll.printPostorder(TreeStructure.root);
				break;
			case 2:
				System.out.print("Enter The Element : ");
				ll.add(sc.nextInt());
				break;
			case 3:
	
				break;
			case 4:
				System.out.print("\nEnter a element to search : ");
				System.out.println(ll.searchElement(sc.nextInt()));
				break;
			case 5:
				System.out.println("Number of nodes in the tree : " + ll.count(TreeStructure.root));
				break;
			case 6:
				System.out.println("Sum of nodes in the tree : " + ll.sumOfNodes(TreeStructure.root));
				break;
			case 7:
				System.out.println("Height of the tree : " + ll.height(TreeStructure.root));
				break;
			case 8:
				System.out.println("Diameter of the tree : " + ll.diameter(TreeStructure.root));
				break;

			default:
				System.out.println("Wrong option choosen");
				break;
			}
			
			System.out.print("\nDo you want to choose again(y/n) : ");
			
		}while(sc.next().equals("y")) ;
		
		
		
	}

}
