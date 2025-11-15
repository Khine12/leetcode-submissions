class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count =0;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for (int r=0; r < rows ; r++){
            
            for(int c=0; c < cols; c++){
                
                if(grid[r][c]=='1'){
                    
                    count++;
                    
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    
                    q.offer(new int[]{r,c});
                    
                    grid[r][c] = '0';
                    
                    while(!q.isEmpty()){
                        
                        int[] cells = q.poll();
                        
                        int x = cells[0];
                        
                        int y = cells[1];
                        
                        for(int[] d : dirs){
                            
                            int nx = x + d[0];
                            
                            int ny = y + d[1];
                            
                            if(nx>=0 && nx<rows && ny>=0 && ny<cols && grid[nx][ny]=='1'){
                                
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
