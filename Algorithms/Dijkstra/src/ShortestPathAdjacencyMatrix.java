import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ShortestPathAdjacencyMatrix {

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

        // Cross Check Graph from https://www.youtube.com/watch?v=WN3Rb9wVYDY

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


        int[] dist_arr = new int[vertices];
        boolean[] visited = new boolean[vertices];

        visited[0] = true ;

        for (int i = 0 ; i < vertices ; i++){
            if (i != 0){
                dist_arr[i] = Integer.MAX_VALUE;
            }
        }

        int start_node = 0 , end_node = 5 , selected_node = start_node;

        System.out.print("Shortest Path -> " + selected_node);

        while (!visited[end_node]){
            int min_node = 0;
            int min_weight = Integer.MAX_VALUE ;
            for (int i = 0 ; i < vertices ; i++){
                int temp_weight = myGraph.adjacency_matrix[selected_node][i] ;
                if (temp_weight != 0 && !visited[i]){
                    if (temp_weight < dist_arr[i]){
                        dist_arr[i] = temp_weight ;
                    }
                    if (temp_weight < min_weight){
                        min_weight = temp_weight ;
                        min_node = i ;
                    }
                }
            }
            selected_node = min_node ;
            visited[selected_node] = true ;
            System.out.print(" -> " + selected_node);
            //System.out.println(Arrays.toString(dist_arr));
            //System.out.println(Arrays.toString(visited));
        }
    }

}
