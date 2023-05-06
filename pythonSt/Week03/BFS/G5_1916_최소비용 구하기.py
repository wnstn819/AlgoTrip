from sys import stdin as s
import heapq

s = open('input.txt','rt')

N = int(s.readline())
M = int(s.readline())

graph = [[] for _ in range(N+1)]
#graph = {}

for _ in range(M):
    start, end , dis = list(map(int,s.readline().split()))
    graph[start].append((dis,end))


start , end = list(map(int,s.readline().split()))


def BFS(start):

    distance = [int(1e9)] * (N+1)
    pq = []
    heapq.heappush(pq,(0,start))
    distance[start] = 0

    while pq:

        d, x = heapq.heappop(pq)

        if distance[x] < d:
            continue
        

        for nw, nx in graph[x]:
                nd = d + nw
                if distance[nx] > nd:
                    heapq.heappush(pq,(nd,nx))
                    distance[nx] = nd

    return distance
            

dist_start = BFS(start)

print(dist_start[end])

