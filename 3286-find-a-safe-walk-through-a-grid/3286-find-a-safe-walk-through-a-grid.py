from typing import List
import heapq
class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        m ,n = len(grid) , len(grid[0])
        
        s_health = health-grid[0][0]

        if s_health <= 0:
            return False

        best = [[-1]*n for _ in range(m)]
        best[0][0] = s_health

        pq = [(-s_health,0,0)]

        dir = [(-1,0),(1,0),(0,-1),(0,1)]

        while pq:
            n_health,i,j = heapq.heappop(pq)

            h = - n_health

            if h < best[i][j]:
                continue

            if i == m- 1 and j == n-1:
                return h>=1

            for di,dj in dir:
                ni,nj = di+i , dj + j
                if 0<= ni <m and 0<= nj <n:
                    nh = h - grid[ni][nj]
                    if nh > best[ni][nj] and nh > 0:
                        best[ni][nj] = nh
                        heapq.heappush(pq, (-nh,ni,nj))

        return best[m-1][n-1] >= 1