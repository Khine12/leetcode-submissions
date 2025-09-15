import java.util.*;
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n=nums.length;
        
        int left=0, sum=0, ans = Integer.MAX_VALUE;
        
        for(int right=0; right<n; right++){
            
            sum += nums[right];
            
            while(sum>=target){
                
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
}
