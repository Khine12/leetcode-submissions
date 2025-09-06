import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;

        // 1) Sort ascending
        Arrays.sort(nums);

        // 2) Count how many DISTINCT values exist
        int distinctNumber = 1;                  // at least one element exists
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) distinctNumber++;
        }

        // 3) If fewer than 3 distinct numbers, return the MAX (last element)
        if (distinctNumber < 3) return nums[n - 1];

        // 4) Otherwise, walk from the end and pick the 3rd DISTINCT value
        long prev = Long.MIN_VALUE;              // sentinel not in int range
        int seen = 0;
        for (int i = n - 1; i >= 0; i--) {
            long v = nums[i];
            if (v != prev) {                     // new unique value
                seen++;
                if (seen == 3) return nums[i];   // 3rd distinct maximum
                prev = v;
            }
        }

        // Shouldn't reach here because distinctNumber >= 3
        return nums[n - 1];
    }
}

