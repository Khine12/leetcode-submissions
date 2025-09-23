class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        Map<Integer,Integer> countAB = new HashMap<>();
        
        for(int a : nums1){
            
            for(int b : nums2){
                
                int s = a+b;
                
                countAB.put(s, countAB.getOrDefault(s,0)+1);
            }
            
        }
        
        int ans = 0;
        
        for(int c : nums3){
            
            for(int d : nums4){
                
                int t = -(c+d);
                
                ans+= countAB.getOrDefault(t,0);
            }
        }
        return ans;
    }
}
