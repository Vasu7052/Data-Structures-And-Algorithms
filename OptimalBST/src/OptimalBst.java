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
		
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}

}
