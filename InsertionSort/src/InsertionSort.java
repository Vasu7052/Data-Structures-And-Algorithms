import java.util.Scanner;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int[] a = new int[sc.nextInt()];
		
		System.out.println("Enter the array : ");
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i ; j > 0 ; j--) {
				if(a[j] < a[j-1]) {
					int temp = a[j] ;
					a[j] = a[j-1] ;
					a[j-1] = temp ;
				}
			}
		}
		
		
		System.out.print("Your Sorted Array : ");
		for (int l = 0; l < a.length; l++) {
			System.out.print(a[l] + " ");
		}
		
	}

}
