import java.util.Scanner;

public class MergeSort {
	
	static int[] a = {5,4,3,2,1} ;
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	/*	System.out.print("Enter the size of the array : ");
		a = new int[sc.nextInt()];
		
		System.out.println("Enter the array : ");
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		} */
		
		
		mergeSort(a , 0 , a.length) ;		
		
		System.out.print("Your Sorted Array : ");
		for (int l = 0; l < a.length; l++) {
			System.out.print(a[l] + " ");
		}
		
	}

	public static void mergeSort(int[] a , int start , int end) {
		
		int N = end-start ;
		
		if(N <= 1) {
			return;
		}
		
		int middle = (start + end)/2 ;
		
		mergeSort(a , start , middle);
		mergeSort(a , middle , end);
		
		
		System.out.print("Recursive Array : ");
		for (int i = start ; i < end ; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		
		int[] temp = new int[N];
        int i = start, j = middle;
        for (int k = 0; k < N; k++) 
        {
        	
        	System.out.println("i(" + i + ") j(" + j + ") Mid(" + middle + ") N(" + N + ")");
        	
            if (i == middle) { 
                temp[k] = a[j++];
                System.out.println("1 Temp " + k + " : " + temp[k]); 
                }
            else if (j == end) {
                temp[k] = a[i++];
                System.out.println("2 Temp " + k + " : " + temp[k]); 
            }
            else if (a[j]<a[i]) {
                temp[k] = a[j++];
                System.out.println("3 Temp " + k + " : " + temp[k]); 
            }
            else { 
                temp[k] = a[i++];
                System.out.println("4 Temp " + k + " : " + temp[k]); 
            }
        }    
        for (int k = 0; k < N; k++) 
            a[start + k] = temp[k]; 
        
        
        System.out.println("---------------------------------------------------------");
		
		
	}

}
