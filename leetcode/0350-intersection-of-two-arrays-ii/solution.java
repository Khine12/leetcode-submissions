class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> freq = new HashMap<>();
        
        for(int x : nums1){
            
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        
        int k=0;
        
        for(int y : nums2){
            
            int c = freq.getOrDefault(y,0);
            
            if(c>0){
                
                nums1[k++]=y;
                
                if(c==1) freq.remove(y);
                
                else freq.put(y,c-1);
            }
               
        }
        
        return Arrays.copyOf(nums1,k);
    }
}
