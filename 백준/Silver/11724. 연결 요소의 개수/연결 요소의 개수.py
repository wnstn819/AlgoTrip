from sys import stdin as s
from collections import deque

N, M = list(map(int,s.readline().split()))

visited = [False] * (N+1)

graph = {}

for i in range(M):
    u, v = list(map(int,s.readline().split()))
    if graph.get(u) == None:
        graph[u] = [v]
    else:
        graph[u].append(v)

    if graph.get(v) == None:
        graph[v] = [u]
    else:
        graph[v].append(u)


def BFS(start):

    q = deque()
    q.append(start)
    visited[start] = True
    while q:
        a = q.popleft()
        if graph.get(a) != None:
            for i in graph[a]:
                if not visited[i]:
                    visited[i] = True
                    q.append(i)

    
count =0


for i in range(1,N+1):
    if not visited[i]:
        BFS(i)
        count +=1

print(count)

