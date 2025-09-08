class Solution {
    public int dominantIndex(int[] nums) {
        int maxNumber =-1;
        int maxIndex=-1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxNumber) {
                maxNumber=nums[i];
                maxIndex=i;
            } 
        }
        for(int i=0;i<nums.length;i++){
            if(i==maxIndex) continue;
            if(maxNumber<2*nums[i]) return -1;
        }
        
        return maxIndex;
    }
}
