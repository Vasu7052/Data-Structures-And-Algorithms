import java.util.Scanner;

public class AdjacencyMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices : ");

        int vertices = sc.nextInt();

        int[][] adjacency_matrix = new int[vertices][vertices];

        String status = "y" ;

        while(status.equals("y")){

            System.out.print("Enter the edge : ");
            int start = sc.nextInt();
            int end = sc.nextInt();

            adjacency_matrix[start-1][end-1] = 1 ;
            adjacency_matrix[end-1][start-1] = 1 ;

            System.out.print("Do you want to add another edge : ");
            status = sc.next();
        }

        System.out.println("Your Adjacency Matrix : ");

        for (int i = 0 ; i < vertices ; i++){
            for (int j = 0 ; j < vertices ; j++){
                System.out.print(adjacency_matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
