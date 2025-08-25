class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        // best: longest streak of 1s seen so far
        int best = 0;
        
        // curr: length of the current running streak of 1s
        int curr = 0;
        
        for (int x : nums) {
            if (x==1) {
                
                // extend the current streak 
                curr ++;
                
                // update the best answer if needed
                if (curr>best) best = curr;
                
            } else {
                
                // 0 breaks the streak
                curr=0;
            }
        }
        return best;
    }
}
