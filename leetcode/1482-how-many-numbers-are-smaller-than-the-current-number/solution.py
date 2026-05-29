class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        
        count = 0
        n = len(nums)
        ans = []

        for i in range(n):

            for j in range(n):

                if i!=j and nums[j] < nums[i]:

                    count = count + 1

            ans.append(count)

            count = 0

        return ans
