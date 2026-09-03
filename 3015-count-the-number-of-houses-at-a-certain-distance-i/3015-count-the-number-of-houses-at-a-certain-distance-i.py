from collections import deque
from typing import List
class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> List[int]:
        x -= 1
        y -= 1
        store = [[] for _ in range(n)]

        for i in range(n-1):
            store[i].append(i+1)
            store[i+1].append(i)

        if x != y:
            store[x].append(y)
            store[y].append(x)

        result = [0]*(n+1)

        for current in range(n):
            count = [-1]*n
            count[current] = 0
            q= deque([current])

            while q:
                curr = q.popleft()
                for nei in store[curr]:
                        if count[nei] == -1:
                            count[nei] = count[curr] + 1
                            q.append(nei)

            for i in range(n):
                if i != current:
                    result[count[i]] += 1

        return result[1:]