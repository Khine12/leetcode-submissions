import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
                
        int top = 0, bottom = m-1;
        int left = 0, right = n-1;
        
        int taken=0, total=m*n;
        
        List<Integer> result = new ArrayList<>(m*n);
        
        while(taken<total){
            
            for(int c=left; c<=right && taken<total; c++){
                result.add(matrix[top][c]); taken++;
            }
            top++;
            
            for(int r=top; r<=bottom && taken<total; r++){
                result.add(matrix[r][right]); taken++;
            }
            right--;
            
            for(int c=right; c>=left && taken<total; c--){
                result.add(matrix[bottom][c]); taken++;
            }
            bottom--;
            
            for(int r=bottom; r>=top && taken<total; r--){
                result.add(matrix[r][left]); taken++;
            }
            left++;
        }
        
        return result;
    }
}
