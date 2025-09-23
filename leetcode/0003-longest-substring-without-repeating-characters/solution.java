import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> last = new HashMap<>();
        
        int left = 0, best = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(last.containsKey(c) && last.get(c)>=left){
                
                left = last.get(c)+1;
            }
            
            last.put(c,i);
            
            best = Math.max(best, i-left+1);
        }
        
        return best;        
    }
}
