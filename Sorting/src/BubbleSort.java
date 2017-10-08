import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int[] array = new int[sc.nextInt()];
		
		System.out.println("Enter the array : ");
		
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		for (int j = 0; j < array.length; j++) {
			for (int k = j+1 ; k < array.length; k++) {
				if(array[j] > array[k]) {
					int temp = array[j] ;
					array[j] = array[k] ;
					array[k] = temp ;
					
				}
			}
		}
		
		System.out.print("Your Sorted Array : ");
		for (int l = 0; l < array.length; l++) {
			System.out.print(array[l] + " ");
		}
		
	}
	
	
}
