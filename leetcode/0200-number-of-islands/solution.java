class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        
        int count = 0;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int r = 0; r<m ; r++){
            
            for(int c = 0; c < n; c++){
                
                if(grid[r][c]=='1'){
                    
                    count++;
                    
                    ArrayDeque<int[]> q = new ArrayDeque<>();
        
                    q.offer(new int[]{r,c});
                        
                    grid[r][c] = '0';
                    
                    while(!q.isEmpty()){
                        
                        int[] curr = q.poll();
                        
                        int x = curr[0], y = curr[1];
                        
                        for(int[] d: dirs){
                            
                            int nx = x + d[0], ny = y + d[1];
                            
                            if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny]=='1'){
                                
                                grid[nx][ny] = '0';
                                
                                q.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
