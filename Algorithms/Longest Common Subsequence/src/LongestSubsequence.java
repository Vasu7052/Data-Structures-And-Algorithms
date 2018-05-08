public class LongestSubsequence {

    
    public static void main(String[] args) {      
        
        
        String[] a1 = {"B","D","C","A","B","A"} ;
        String[] a2 = {"A","B","C","B","D","A","B"} ; 
        
        // ANS = BCBA
        
        int i1 = a2.length+1 ;
        int j1 = a1.length+1 ;
        
        int[][] data = new int[a2.length+1][a1.length+1] ;
        
        String[][] arrow = new String[a2.length+1][a1.length+1] ;
        
        
        for (int i = 0; i < i1 ; i++) {
            
            data[i][0] = 0 ;
            
        }
        
        for (int i = 0; i < j1 ; i++) {
            
            data[0][i] = 0 ;
            
        }
        
        for (int i = 1 ; i < i1 ; i++) {
            
            for (int j = 1 ; j < j1 ; j++) {
            
            if(a1[j-1] == a2[i-1]){
                data[i][j] = data[i-1][j-1] + 1;
                arrow[i][j] = "diagonal" ;
            }else{
                
                if(data[i-1][j] >= data[i][j-1]){
                data[i][j] = data[i-1][j];
                arrow[i][j] = "up" ;
                }else{
                data[i][j] = data[i][j-1];
                arrow[i][j] = "left" ;
                }
            
            }
            
        }
            
        }
        
     /*   for (int i = 0 ; i < i1 ; i++) {
            
            for (int j = 0 ; j < j1 ; j++) {
            
                System.out.print(data[i][j] + " ");
            
        }System.out.println("");   
        }
      
        System.out.println();
        for (int i = 0 ; i < i1 ; i++) {
            
            for (int j = 0 ; j < j1 ; j++) {
            
                System.out.print(arrow[i][j] + " ");
            
        }System.out.println("");   
        } */
        
        String[] temp = new String[5] ;
        
        int iTemp = i1-1 ;
        int jTemp = j1-1 ;
        int count = 0 ;
        
        while(iTemp > 1 || jTemp > 1 ){
        
            if(arrow[iTemp][jTemp] != null && arrow[iTemp][jTemp].equals("diagonal")){
                
                temp[count] = a2[iTemp-1];
                count++ ;
                iTemp-- ;
                jTemp-- ;
            
            }else if(arrow[iTemp][jTemp] != null && arrow[iTemp][jTemp].equals("up")){
                iTemp-- ;
            }else{
                jTemp-- ;
            }
            
        }
        
        System.out.print("Longest Subsequence : ");
        
        for (int i = 0; temp[i] != null ; i++) {
            System.out.print(temp[i] + " ");
            
        }
        System.out.println("");  
    }
    
}