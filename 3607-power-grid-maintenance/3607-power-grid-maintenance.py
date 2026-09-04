import heapq
from typing import List
class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        parent = list(range(c+1))
        rank = [0]*(c+1)

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a,b):
            ra,rb = find(a),find(b)
            if ra == rb:
                return
            if rank[ra] < rank[rb]:
                ra,rb = rb,ra
            parent[rb] = ra
            if rank[ra] == rank[rb]:
                rank[ra] += 1

        for u,v in connections:
            union(u,v)

        heaps = {}
        for node in range(1,c+1):
            root = find(node)
            heaps.setdefault(root,[]).append(node)
        for root in heaps:
            heapq.heapify(heaps[root])

        offline = set()
        result = []

        for query in queries:
            if query[0] == 1:
                x = query[1]
                if x not in offline:
                    result.append(x)
                else:
                    root = find(x)
                    heap = heaps[root]
                    while heap and heap[0] in offline:
                        heapq.heappop(heap)
                    result.append(heap[0] if heap else -1)

            else:
                offline.add(query[1])

        return result