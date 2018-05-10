import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class AdjacencyMatrix {

    static class MyGraph{

        int[][] adjacency_matrix ;
        int vertices ;

        MyGraph(int vertices){
            this.vertices = vertices ;
            this.adjacency_matrix = new int[vertices][vertices];
        }

        public void add_edge(int src, int dest , int weight){
            adjacency_matrix[src][dest] = weight ;
            adjacency_matrix[dest][src] = weight ;
        }

        public void display_matrix(){
            for (int i = 0 ; i < this.vertices ; i++){
                for (int j = 0 ; j < this.vertices ; j++){
                    System.out.print(this.adjacency_matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {

        int vertices = 6 ;

        MyGraph myGraph = new MyGraph(vertices) ;

        myGraph.add_edge(0 , 1 , 4);
        myGraph.add_edge(0 , 2 , 2);
        myGraph.add_edge(1 , 3 , 5);
        myGraph.add_edge(1 , 2 , 1);
        myGraph.add_edge(2 , 3 , 8);
        myGraph.add_edge(2 , 4 , 10);
        myGraph.add_edge(3 , 4 , 2);
        myGraph.add_edge(3 , 5 , 6);
        myGraph.add_edge(4 , 5 , 3);

        System.out.println("Your Adjacency Matrix : ");

        myGraph.display_matrix();

    }

}
