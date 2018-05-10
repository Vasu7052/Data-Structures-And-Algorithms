import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Main {

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

        // Cross Check Graph from http://www.programming-algorithms.net/article/45708/Floyd-Warshall-algorithm

        int vertices = 5 ;

        MyGraph myGraph = new MyGraph(vertices) ;

        myGraph.add_edge(0 , 1 , 5);
        myGraph.add_edge(0 , 3 , 2);
        myGraph.add_edge(1 , 2 , 2);
        myGraph.add_edge(2 , 4 , 7);
        myGraph.add_edge(2 , 0 , 3);
        myGraph.add_edge(3 , 4 , 1);
        myGraph.add_edge(3 , 2 , 4);
        myGraph.add_edge(4 , 1 , 3);
        myGraph.add_edge(4 , 0 , 1);

        System.out.println("Your Adjacency Matrix : ");

        myGraph.display_matrix();

        int[][][] dist_arr = new int[vertices+1][vertices][vertices];


        for (int i = 0 ; i < vertices ; i++){
            for (int j = 0 ; j < vertices ; j++){
                int temp_weight = myGraph.adjacency_matrix[i][j] ;
                if (temp_weight == 0) {
                    if (i != j) dist_arr[0][i][j] = Integer.MAX_VALUE;
                }
                else dist_arr[0][i][j] = temp_weight ;
            }
        }

        for (int k = 1 ; k <=vertices ; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (i == (k-1) || j == (k-1)){
                        dist_arr[k][i][j] = dist_arr[k-1][i][j] ;
                    }else if(i == j){
                        dist_arr[k][i][j] = 0 ;
                    }else{
                        int prev_value = dist_arr[k-1][i][j] ;
                        int new_val1 = dist_arr[k-1][i][k-1];
                        int new_val2 = dist_arr[k-1][k-1][j];
                        int sum = 0 ;
                        if (new_val1 == Integer.MAX_VALUE || new_val2 == Integer.MAX_VALUE){
                            sum = Integer.MAX_VALUE;
                        }else{
                            sum = new_val1 + new_val2 ;
                        }
                        if (sum < prev_value){
                            dist_arr[k][i][j] = sum ;
                        }else{
                            dist_arr[k][i][j] = prev_value ;
                        }
                    }

                }
            }
        }

        for (int k = 0 ; k <=vertices ; k++) {
            System.out.println("D " + k + " -------------------------------------------------------");
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    System.out.print(" " + dist_arr[k][i][j]);
                }
                System.out.println();
            }
        }


    }

}
