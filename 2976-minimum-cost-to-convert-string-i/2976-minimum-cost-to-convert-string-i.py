class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:

        INF = float('inf')
        store = [[INF]*26 for _ in range(26)]
        
        for i in range(26):
            store[i][i] = 0

        for o,c,w in zip(original,changed,cost):
            
            s = ord(o) - ord('a')
            f = ord(c) - ord('a')
            store[s][f] = min(store[s][f],w)

        for k in range(26):
            for i in range(26):
                if store[i][k] == INF:
                    continue
                for j in range(26):
                    if store[i][k] + store[k][j] < store[i][j]:
                        store[i][j] = store[i][k] + store[k][j]

        total = 0

        for s,t in zip(source,target):
            if s == t:
                continue
            o = ord(s) - ord('a')
            c = ord(t) - ord('a')

            if store[o][c] == INF:
                return -1
            total += store[o][c]

        return total