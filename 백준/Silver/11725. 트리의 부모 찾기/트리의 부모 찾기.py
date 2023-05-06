from sys import stdin as s
from collections import deque
import sys
sys.setrecursionlimit(10**6)

n = int(s.readline())

parent = [0 for i in range(n+1)]
graph = {}
visited = [False] * (n +1)


for _ in range(n-1):
    u, v = list(map(int,s.readline().split()))
    if graph.get(u) == None:
        graph[u]= [v]

    else :
        graph[u].append(v)

    if graph.get(v) == None:
        graph[v]= [u]

    else :
        graph[v].append(u)

def DFS(start):
    if graph.get(start) == None:
        return
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            parent[i] = start
            DFS(i)


DFS(1)

for i in parent[2:]:
    print(i)




