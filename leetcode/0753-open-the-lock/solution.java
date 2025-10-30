class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        
        String start = "0000";
        
        if(dead.contains(start)) return -1;
        
        if(target.equals(start)) return 0;
        
        Deque<String> q= new ArrayDeque<>();
        
        Set<String> seen = new HashSet<>();
        
        int steps = 0;
        
        q.offer(start);
        
        seen.add(start);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                
                String curr = q.poll();
                
                if(curr.equals(target)) return steps;
                
                for(String nxt : neighbors(curr)){
                    
                    if(!dead.contains(nxt) && seen.add(nxt)){
                        
                        q.offer(nxt);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private List<String> neighbors(String s){
        
        List<String> res = new ArrayList<>(8);
        
        char[] a = s.toCharArray();
        
        for(int i=0; i<4; i++){
            
            char d = a[i];
            
            a[i] = d == '9' ? '0' : (char)(d+1);
            
            res.add(new String (a));
            
            a[i] = d == '0' ? '9' : (char)(d-1);
            
            res.add(new String (a));
            
            a[i] = d;
        }
        
        return res;
    }
}
