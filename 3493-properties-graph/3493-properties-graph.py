from collections import defaultdict
class Solution:
    def numberOfComponents(self, properties: List[List[int]], k: int) -> int:
        n = len(properties)
        count = 0
        visited = [False]*n
        store = defaultdict(list)

        sets = [set(p) for p in properties]

        for i in range(n):
            for j in range(i+1,n):
                if len(sets[i] & sets[j]) >= k:
                    store[i].append(j)
                    store[j].append(i)

        def dfs(node):
            visited[node] = True
            for neighbor in store[node]:
                if not visited[neighbor]:
                    dfs(neighbor)

        for i in range(n):
            if not visited[i]:
                dfs(i)
                count += 1
                
        return count