
public class OptimalSolution {
	
	static int[] matrices = {40, 20, 30, 10, 30} ;
	
	public static void main(String[] args) {
		
		int len1 = matrices.length ;
		
		int[][] solution = new int[len1-1][len1-1] ;
		
		for(int i = 0 ; i < solution.length ; i++) {
			for(int j = 0 ; j < solution.length ; j++) {
				solution[i][j] = 0 ;
			}
		}
		
		
		for (int i = 0 ; i < 4 ; i++) {
			
			for (int j = 0; j < solution.length - 1; j++) {
				
				for (int k = i+j+1 ; k < solution.length ; k++) {
					
					if(k == i+j+1) {
						solution[j][k] = findMinimum(solution , j , k);
					}
					
				}
				
				
			}
		}
		
		System.out.println("Minimum number of multiplications : " + solution[0][solution.length-1]);
		
		
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
