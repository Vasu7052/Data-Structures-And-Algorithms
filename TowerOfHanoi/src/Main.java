import java.util.Scanner;

public class Main {
	
	static int moves = 1 ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of disks : ");
		
		toh( sc.nextInt() , "A" , "B" , "C");
		
		System.out.println("Total Moves : " + (moves-1));
		
	}
	
	public static void toh(int numberOfDisks ,String start ,String aux ,String destination) {
		
		if(numberOfDisks == 1) {
			System.out.println("Moves : " + moves + " > " + start + " to " + destination);
			moves++ ;
		}else {
		toh(numberOfDisks-1 , start , destination , aux) ;
		toh(1 , start , aux , destination) ;
		toh(numberOfDisks-1 , aux , start , destination) ;
		}
		
	}

}
