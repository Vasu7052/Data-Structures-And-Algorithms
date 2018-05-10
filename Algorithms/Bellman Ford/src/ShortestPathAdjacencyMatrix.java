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

        // Cross Check Graph from https://www.programiz.com/dsa/bellman-ford-algorithm

        int vertices = 5 ;

        MyGraph myGraph = new MyGraph(vertices) ;

        myGraph.add_edge(0 , 1 , 4);
        myGraph.add_edge(0 , 2 , 2);
        myGraph.add_edge(1 , 3 , 2);
        myGraph.add_edge(1 , 2 , 3);
        myGraph.add_edge(1 , 4 , 3);
        myGraph.add_edge(2 , 1 , 1);
        myGraph.add_edge(2 , 3 , 4);
        myGraph.add_edge(2 , 4 , 5);
        myGraph.add_edge(4 , 3 , -5);

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

       for (int k = 0 ; k < vertices-1 ; k++){
           if (k == 0){
               for (int i = 0 ; i < vertices ; i++){
                   int temp_weight = myGraph.adjacency_matrix[0][i] ;
                   if (temp_weight != 0 && temp_weight < dist_arr[i]){
                       dist_arr[i] = temp_weight ;
                   }
               }
           }else{
               for (int i = 1 ; i < vertices ; i++){
                   for (int j = 1 ; j < vertices ; j++){
                       int distance = myGraph.adjacency_matrix[i][j];
                       if (distance != 0){
                           int sum_distance = dist_arr[i] + distance;
                           if (sum_distance < dist_arr[j]){
                               dist_arr[j] = sum_distance ;
                           }
                       }
                   }
               }
           }
           System.out.println(Arrays.toString(dist_arr));
       }

    }

}
