class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        max_count = 0 
        count = 0
        n = len(nums)

        for i in range(n):

            if nums[i] == 0:

                max_count = max(max_count,count)
                count = 0

            elif i == n-1:

                if nums[n-1] == 1:

                    count = count + 1

                max_count = max(max_count,count)

            else:

                count = count + 1

        return max_count

            
