import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freq = new HashMap<>();
        
        for(int x : nums){
            
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        
        List<Integer>[] store = new List[nums.length+1];
        
        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            
            int number = e.getKey();
            
            int t = e.getValue();
            
            if(store[t]==null) store[t]=new ArrayList<>();
            
            store[t].add(number);
        }
        
        int[] ans = new int[k];
        
        int idx = 0; 
        
        for(int i=store.length-1; i>=0 && idx<k; i--){
            
            if(store[i]==null) continue; 
            
            for(int x : store[i]){
                
                ans[idx++] = x;
                
                if(idx==k) break;
            }
        }
        return ans;
    }
}
