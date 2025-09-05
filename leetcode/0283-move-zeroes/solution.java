class Solution {
    public void moveZeroes(int[] nums) {
        
        int n=nums.length;
        int write =0;
        
        for (int readPointer =0; readPointer < n; readPointer++) {
                        
            if(nums[readPointer] != 0) {
                
                nums[write] = nums[readPointer];
                write++;
            }
        }
        
        while (write < n) {
            
            nums[write] = 0;
            write++;
        }
        
    }
}
