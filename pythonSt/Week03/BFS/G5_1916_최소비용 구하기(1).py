from sys import stdin as s
from collections import deque
import heapq

s = open('input.txt','rt')

N = int(s.readline())
M = int(s.readline())

graph = {}

for _ in range(M):
    start, end , dis = list(map(int,s.readline().split()))
    graph[start] = graph.get(start,[]) + [(dis,end)]


start , end = list(map(int,s.readline().split()))


def BFS(start):
    q = deque()
    q.append((0,start))
    distance = [int(1e9)] * (N+1)
    distance[start] = 0


    while q:
        dist, a = q.popleft()
        if distance[a] < dist:
            continue
        if graph.get(a) != None:
            for e,i in graph[a]:
                if distance[i] > e+distance[a]:
                    distance[i] = min(e + distance[a],distance[i])
                    q.append((distance[i],i))

    return distance
            

dist_start = BFS(start)

print(dist_start[end])

