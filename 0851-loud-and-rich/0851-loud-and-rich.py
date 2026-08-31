class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        n = len(quiet)
        answer = [-1]*n
        mapStore = defaultdict(list)

        for a,b in richer:
            mapStore[b].append(a)

        def dfs(x):
            if answer[x] != -1:
                return answer[x]
            answer[x] = x

            for a in mapStore[x]:
                quietest = dfs(a)

                if quiet[quietest] < quiet[answer[x]]:
                    answer[x] = quietest
            return answer[x]

        for x in range(n):
            dfs(x)
        return answer