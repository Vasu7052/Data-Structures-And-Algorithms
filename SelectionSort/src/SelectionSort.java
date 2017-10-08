import java.util.*;

public class SelectionSort {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int[] a = new int[sc.nextInt()];
		
		int smallestElement , position  ;
		
		
		System.out.println("Enter the array : ");
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < a.length; i++) {
			
			position = i ;
			for (int j = i+1 ; j < a.length; j++) {
				
				if(a[j] < a[position]) {
					position = j ;
				}
				
			}
			
			int temp = a[i] ;
			a[i] = a[position] ;
			a[position] = temp ;
			
		}
		
		
		
		System.out.print("Your Sorted Array : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}

}
