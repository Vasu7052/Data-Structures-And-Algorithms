public class HeapSort {

    static class MyHeap {

        int[] arr , sorted_arr;

        MyHeap(int[] array) {
            this.arr = array;
            this.sorted_arr = array ;
        }

        private int getLeftChildIndex(int parentIndex) {
            return ((2 * parentIndex) + 1);
        }

        private int getRightChildIndex(int parentIndex) {
            return ((2 * parentIndex) + 2);
        }

        private int getParentIndex(int childIndex) {
            return ((childIndex - 1) / 2);
        }

        private boolean hasLeftChild(int index) {
            return (getLeftChildIndex(index) < this.arr.length);
        }

        private boolean hasRightChild(int index) {
            return (getRightChildIndex(index) < this.arr.length);
        }

        private boolean hasParent(int index) {
            return (getParentIndex(index) >= 0);
        }

        private int getLeft(int index) {
            return this.arr[getLeftChildIndex(index)];
        }

        private int getRight(int index) {
            return this.arr[getRightChildIndex(index)];
        }

        private int getParent(int index) {
            return this.arr[getParentIndex(index)];
        }

        private void swap(int indexOne, int indexTwo) {
            int temp = this.arr[indexOne];
            this.arr[indexOne] = this.arr[indexTwo];
            this.arr[indexTwo] = temp;
        }

        private void shrink_array(){
            int[] n = new int[this.arr.length - 1];
            System.arraycopy(this.arr, 0, n, 0, n.length );
            System.arraycopy(this.arr, 0, this.sorted_arr, 0, this.arr.length );
            this.arr = n ;
        }

        private void heapifyUp() {
            int index = this.arr.length - 1;
            while (hasParent(index) && getParent(index) < this.arr[index]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        private void heapifyDown(int index) {

                if (!hasLeftChild(index)){
                    return;
                }

                int biggerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getRight(index) > getLeft(index)) {
                    biggerChildIndex = getRightChildIndex(index);
                }

                //System.out.println("Index : " + );

                if (arr[index] < this.arr[biggerChildIndex]) {
                    swap(index, biggerChildIndex);
                }

                heapifyDown(getLeftChildIndex(index));
                if (!hasRightChild(index)){
                    heapifyDown(getRightChildIndex(index));
                }

        }

        private void display_sorted() {
            for (Integer item : this.sorted_arr) {
                System.out.print(item + "->");
            }
            System.out.println("End");
        }

        private void display_heap() {
            for (Integer item : this.arr) {
                System.out.print(item + "->");
            }
            System.out.println("End");
        }

    }

    public static void main(String[] args) {

        int[] array = {4, 10, 3, 5, 1};

        int size = array.length ;

        MyHeap myHeap = new MyHeap(array);

        System.out.println("UNSORTED : ");
        myHeap.display_sorted();

        for (int i = (size-1) ; i > 0 ; i--){
            myHeap.heapifyDown(0);
            myHeap.swap(0 , myHeap.arr.length-1);
            myHeap.shrink_array();
            //System.out.println("DONE : " + i);
        }

        System.out.println("SORTED : ");
        myHeap.display_sorted();

    }

}
