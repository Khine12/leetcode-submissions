class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> idx = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            
            int need = target - nums[i];
            
            if(idx.containsKey(need)) {
                
                return new int[]{idx.get(need),i};
            }
            
            idx.put(nums[i],i);
        }
        return new int[0];
    }
}
