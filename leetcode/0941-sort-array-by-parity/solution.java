class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int write = 0;
        int n = nums.length;
        
        for (int read=0; read < n; read++) {
            
            if (nums[read]%2==0) {
                
                if (read != write) {
                    
                    int t = nums[write];
                    nums[write] = nums[read];
                    nums[read] = t;
                    
                } write++;
            }
        }
                
        return nums;
    }
}
