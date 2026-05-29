class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        s = set()
        duplicated = -1 
        missing = -1

        for i in range(n):

            if nums[i] in s:

                duplicated = nums[i]

            else:

                s.add(nums[i])

        for i in range(1,n+1):

            if i not in s:

                missing = i

        return [duplicated,missing]
