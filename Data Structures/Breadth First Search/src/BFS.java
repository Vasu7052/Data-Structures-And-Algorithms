import java.util.*;

public class BFS {

    static class MyGraph {

        LinkedList<Integer> adjacency_list[];
        int vertices;

        MyGraph(int vertices) {
            this.vertices = vertices;
            this.adjacency_list = new LinkedList[this.vertices];
            for (int i = 0; i < this.vertices; i++) {
                this.adjacency_list[i] = new LinkedList<>();
            }
        }

        public void addData(int src, int dest) {
            this.adjacency_list[src].addFirst(dest);
            this.adjacency_list[dest].addFirst(src);
        }

        public void display_list() {
            for (int i = 0; i < this.vertices; i++) {
                System.out.print("Vertex " + i + " ");
                for (Integer item : this.adjacency_list[i]) {
                    System.out.print("->" + item);
                }
                System.out.println();
            }
        }

        public void start_searching(int start){
            Queue<Integer> queue = new LinkedList<>();

            boolean[] visitied = new boolean[vertices];

            for (int i = 0 ; i < vertices ; i++){
                visitied[i] = false ;
            }

            visitied[start] = true ;
            queue.add(start);

            while (queue.size() != 0){

                int vertex = (int) queue.peek();

                for (Integer item : this.adjacency_list[vertex]){
                    if (!visitied[item]){
                        queue.add(item);
                        visitied[item] = true ;
                    }
                }

                queue.poll();
                System.out.print(" -> " + vertex);
            }
        }

    }

    public static void main(String[] args) {

        int vertices = 6;

        MyGraph graph = new MyGraph(vertices);

        graph.addData(0, 1);
        graph.addData(0, 2);
        graph.addData(1, 3);
        graph.addData(1, 4);
        graph.addData(2, 4);
        graph.addData(3, 4);
        graph.addData(3, 5);
        graph.addData(4, 5);

        System.out.println("Your Adjacency Matrix : ");

        graph.display_list();

        graph.start_searching(2);

    }

}


