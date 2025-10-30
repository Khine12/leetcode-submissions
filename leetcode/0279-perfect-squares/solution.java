class Solution {
    public int numSquares(int n) {
        
        int maxS = (int)Math.sqrt(n);
        
        int[] squares = new int[maxS];
        
        for(int i=1; i<=maxS; i++) squares[i-1] = i*i;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        boolean[] seen = new boolean[n+1];
        
        q.offer(n);
        
        seen[n] = true;
        
        int steps = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                
                int curr = q.poll();
                
                if(curr==0) return steps;
                
                for(int sq : squares){
                    
                    int nxt = curr-sq;
                    
                    if(nxt<0) break;
                    
                    if(!seen[nxt]){
                        
                        if(nxt==0) return steps+1;
                        
                        seen[nxt] = true;
                        
                        q.offer(nxt);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
