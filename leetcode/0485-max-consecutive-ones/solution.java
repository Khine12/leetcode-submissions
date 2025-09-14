class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int counter=0;
        
        int maxCounter=0;
        
        for(int i=0; i<nums.length; i++) {
           
            if(nums[i]==1){
                counter++;
                if(counter>=maxCounter){
                    maxCounter=counter;
                }
            }
            else if(nums[i]==0){
                counter =0;
            }
            
        }
        return maxCounter;
    }
}
