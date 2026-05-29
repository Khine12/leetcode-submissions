class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        
        m = len(target)
        ans = []

        for i in range(1,n+1):

            if i in target:
                ans.append("Push")

            elif i not in target and i <= target[m-1]:
                ans.append("Push")
                ans.append("Pop")

            else:
                continue

        return ans
