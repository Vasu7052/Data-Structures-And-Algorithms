import java.util.LinkedList;
import java.util.Scanner;

public class AdjacencyList {

    static class MyGraph{

        LinkedList<Integer> adjacency_list[] ;
        int vertices;

        MyGraph(int vertices){
            this.vertices = vertices ;
            this.adjacency_list = new LinkedList[this.vertices];
            for(int i = 0; i < this.vertices ; i++){
                this.adjacency_list[i] = new LinkedList<>();
            }
        }

        public void addData(int src , int dest){
            this.adjacency_list[src].addFirst(dest);
            this.adjacency_list[dest].addFirst(src);
        }

        public void display_list(){
            for (int i = 0; i < this.vertices; i++) {
                System.out.print("Vertex " + i + " ");
                for (Integer item : this.adjacency_list[i]) {
                    System.out.print("->" + item);
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = 5 ;

        MyGraph graph = new MyGraph(vertices);

        graph.addData( 0 , 1);
        graph.addData( 0 , 4);
        graph.addData( 1 , 4);
        graph.addData( 1 , 3);
        graph.addData( 1 , 2);
        graph.addData( 3 , 4);
        graph.addData( 2 , 3);

        System.out.println("Your Adjacency Matrix : ");

        graph.display_list();

    }
}