class Solution:
    def maxAmount(self, initialCurrency: str, pairs1: List[List[str]], rates1: List[float], pairs2: List[List[str]], rates2: List[float]) -> float:
        from collections import defaultdict
        def build_store(pairs,rates):
            store = defaultdict(list)

            for (a,b),r in zip(pairs,rates):
                store[a].append((b,r))
                store[b].append((a,1/r))
            return store

        def reachable_amount(store,start):
            amount = {start : 1.0}
            stack = [start]
            while stack:
                node = stack.pop()
                for nei,rate in store[node]:
                    if nei not in amount:
                        amount[nei] = amount[node]*rate
                        stack.append(nei)
            return amount

        store1 = build_store(pairs1,rates1)
        store2 = build_store(pairs2,rates2)
        day1 = reachable_amount(store1,initialCurrency)
        day2 = reachable_amount(store2,initialCurrency)
        best = 1.0

        for node,amt in day1.items():
            if node in day2:
                best = max(best,amt/day2[node])
        return best