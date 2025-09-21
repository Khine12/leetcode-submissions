class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        
        for (int x: nums1){
            
            set1.add(x);
        }
        
        Set<Integer> result = new HashSet<>();
        
        for (int y: nums2){
            
            if(set1.contains(y)){
                
                result.add(y);
            }
        }
        
        int[] ans = new int[result.size()];
        
        int i=0;
        
        for(int val: result){
            
            ans[i++]=val;
        }
        return ans;
    }
}
