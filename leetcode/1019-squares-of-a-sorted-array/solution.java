import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n=nums.length;
        int L=0;
        int R=n-1;
        int write=n-1;
        
        int[]ans = new int[n];
        
        while(L<=R){
            int left = nums[L]*nums[L];
            int right = nums[R]*nums[R];
            
            if(left>right){
                ans[write--]=left;
                L++;
            } else {
                ans[write--]=right;
                R--;
            }
        }
        return ans;
    }
}
