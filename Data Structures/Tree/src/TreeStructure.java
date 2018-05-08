public class TreeStructure{

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