import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        
        int n = mat[0].length;
        
        int[][] ans = new int[m][n];
        
        Queue <int[]> q = new ArrayDeque<>();
        
        int INF = Integer.MAX_VALUE;
        
        for (int i=0; i<m ; i++){
            
            for (int j=0; j<n; j++){
                
                if(mat[i][j]==0){
                    
                    ans[i][j] = 0;
                    
                    q.offer(new int[] {i,j});
                }
                else{
                    
                    ans[i][j] = INF;
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            
            int[] cells = q.poll();
            
            int r = cells[0];
            
            int c = cells[1];
            
            for(int[] d : dirs){
                
                int nr = d[0] + r;
                
                int nc = d[1] + c;
                
                if(nr < 0 || nr >= m || nc < 0 || nc >=n ){
                    
                    continue;
                }
                
                if(ans[nr][nc] > ans[r][c]+1){
                    
                    ans[nr][nc] = ans[r][c]+1;
                    
                    q.offer(new int[] {nr,nc});
                }
            }
        }
        return ans;
    }
}
