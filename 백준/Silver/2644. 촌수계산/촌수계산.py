from sys import stdin as s
from collections import deque

n = int(s.readline())

start,end = list(map(int,s.readline().split()))

m = int(s.readline())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = list(map(int,s.readline().split()))
    graph[u].append(v)
    graph[v].append(u)


visited = [False] * (n+1)
result = -1
def BFS(start):
    q = deque()
    q.append((start,1))
    visited[start] = True

    while q :
        a,depth = q.popleft()
        
        for i in graph[a]:
            if not visited[i]:
                visited[i] = True
                if i == end:
                    result = depth
                    print(result)
                    exit()
                q.append((i,depth+1))


BFS(start)
print(result)