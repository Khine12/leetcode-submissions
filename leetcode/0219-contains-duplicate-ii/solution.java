class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer,Integer> ans = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            
            int v = nums[i];
            
            Integer prev = ans.get(v);
            
            if(prev != null && i-prev <=k) return true;
            
            ans.put(v,i);
        }
        return false;
    }
}
