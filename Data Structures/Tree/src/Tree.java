import java.util.Scanner;

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
