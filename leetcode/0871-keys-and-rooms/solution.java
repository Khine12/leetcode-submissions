class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        
        visited[0] = true;
        
        Stack <Integer> stack = new Stack<>();
        
        stack.push(0);
        
        while(!stack.isEmpty()){
            
            int currRoom = stack.pop();
            
            for(int keys : rooms.get(currRoom)){
                
                if(!visited[keys]){
                    
                    visited[keys] = true;
                    
                    stack.push(keys);
                }
            }
        }
        
        for (boolean v : visited){
            
            if(!v){
                
                return false;
            }
        }
        return true;
    }
}
