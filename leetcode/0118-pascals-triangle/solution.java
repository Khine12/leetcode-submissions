import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(Arrays.asList(1));
        
        for(int r=2; r<=numRows; r++){
            List<Integer> prev = result.get(result.size()-1);
            List<Integer> curr = new ArrayList<>();
            
            curr.add(1);
            
            for(int j=1; j<r-1; j++){
                
                curr.add(prev.get(j-1)+prev.get(j));
            }
            
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}
