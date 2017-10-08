import javax.lang.model.element.Element;

public class OptimalBst {
	
	static int[] elements = {5,6,8,20};
	
	static int[] access = {4,2,6,3} ;
	
	public static void main(String[] args) {
		
		int len = elements.length ;
		
		int[][] solution = new int[len][len] ;
		
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				solution[i][j] = 0 ;
			}
		}
		
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				if(i == j) {
					solution[i][j] = access[i] ;
				}
			}
		}
		
		for (int i = 0 ; i < solution.length-1 ; i++) {
			
			for (int j = 0; j < solution.length - 1; j++) {
				
				for (int k = i+j+1 ; k < solution.length ; k++) {
					
					if(k == i+j+1) {
						solution[j][k] = findMinimum(solution , j , k);
					}
					
				}
				
				
			}
		}
		
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int findMinimum(int[][] array , int i , int j){
		
		int min = Integer.MAX_VALUE ;
		
		for (int k = i ; k < j ; k++) {
			
			int temp = array[i][k] + array[k+1][j] + (matrices[i]*matrices[k+1]*matrices[j+1]) ;
			
			if(temp <= min) {
				min = temp ;
			}
		}
		
		return min ;
		
	}
	

}
