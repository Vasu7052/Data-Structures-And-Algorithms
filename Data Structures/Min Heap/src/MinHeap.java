import java.util.ArrayList;

public class MinHeap {

    static class MyHeap{

        ArrayList<Integer> items = new ArrayList<>();

        private int getLeftChildIndex(int parentIndex){
            return ((2 * parentIndex) + 1) ;
        }

        private int getRightChildIndex(int parentIndex){
            return ((2 * parentIndex) + 2) ;
        }

        private int getParentIndex(int childIndex){
            return ((childIndex - 1)/2) ;
        }

        private boolean hasLeftChild(int index){
            return (getLeftChildIndex(index) < items.size());
        }

        private boolean hasRightChild(int index){
            return (getRightChildIndex(index) >= items.size());
        }

        private boolean hasParent(int index){
            return (getParentIndex(index) >= 0);
        }
        
        private int getLeft(int index){
            return items.get(getLeftChildIndex(index));
        }

        private int getRight(int index){
            return items.get(getRightChildIndex(index));
        }

        private int getParent(int index){
            return items.get(getParentIndex(index));
        }

        private void swap(int indexOne , int indexTwo){
            int temp = items.get(indexOne);
            items.set(indexOne , items.get(indexTwo));
            items.set(indexTwo , temp);
        }

        private void add(int element){
            items.add(element);
            heapifyUp();
        }

        private void heapifyUp(){
            int index = items.size() - 1 ;
            while (hasParent(index) && getParent(index) > items.get(index)){
                swap(index , getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        private void display_heap(){
            for (Integer item : items){
                System.out.print(item + "->");
            }
            System.out.println("End");
        }
        
    }

    public static void main(String[] args) {

        // Heap image Reference http://ramos.elo.utfsm.cl/~lsb/elo320/aplicaciones/aplicaciones/CS460AlgorithmsandComplexity/lecture13/COMP460%20Algorithms%20and%20Complexity%20Lecture%2013_archivos/heap3.gif

        MyHeap myHeap = new MyHeap();

        myHeap.add(3);
        myHeap.add(10);
        myHeap.add(8);
        myHeap.add(5);
        myHeap.add(2);
        myHeap.add(4);

        myHeap.display_heap();
    }

}
