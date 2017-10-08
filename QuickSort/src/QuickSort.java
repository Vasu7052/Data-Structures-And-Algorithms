import java.util.Scanner;

public class QuickSort {
	
	static int[] a ;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		a = new int[sc.nextInt()];
		
		System.out.println("Enter the array : ");
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		quickSort(0 , a.length - 1) ;
		
		
		System.out.print("Your Sorted Array : ");
		for (int l = 0; l < a.length; l++) {
			System.out.print(a[l] + " ");
		}
		
	}
	
	public static void quickSort(int lowerIndex , int higherIndex) {
		
		int i = lowerIndex ;
		int j = higherIndex ;
		
		while(i <= j) {
			
			int pivot = a[lowerIndex + (higherIndex - lowerIndex)/2] ;
			System.out.println("Pivot : " + pivot);
			
			while(a[i] < pivot) {
				i++ ;
			}
			while(a[j] > pivot) {
				j-- ;
			}
			if (i <= j) {
			int temp = a[i] ;
			a[i] = a[j] ;
			a[j] = temp ;
			i++ ;
			j-- ;	
		}
		
		if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
		
	}
}
	
}
