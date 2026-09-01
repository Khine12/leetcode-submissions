import heapq
from typing import List

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        Map = {i:[] for i in range(1,n+1)}

        for u,v,w in times:
            Map[u].append((v,w))

        dist = {i:float('inf') for i in range(1,n+1)}
        dist[k] = 0

        heap = [(0,k)]

        while heap:
            d,node = heapq.heappop(heap)

            for neighbor, distance in Map[node]:
                new_distance = d + distance

                if new_distance < dist[neighbor]:
                    dist[neighbor] = new_distance

                    heapq.heappush(heap,(new_distance,neighbor))

        max_distance = max(dist.values())
        return max_distance if max_distance != float('inf') else -1