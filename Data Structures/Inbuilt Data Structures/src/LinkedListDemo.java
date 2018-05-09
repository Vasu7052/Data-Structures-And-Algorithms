import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();

        myList.add("Ravi");
        myList.add("Vijay");
        myList.add("Ravi");
        myList.add("Ajay");

        myList.addFirst("List of names");
        myList.addLast("End of names");

        for (String item : myList){
            System.out.println(item);
        }

    }

}
