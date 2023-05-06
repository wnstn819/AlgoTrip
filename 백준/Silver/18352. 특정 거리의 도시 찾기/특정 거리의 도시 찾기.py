from sys import stdin as s
from collections import deque

N, M, K, X = list(map(int, s.readline().split()))

graph =[[] for _ in range(N+1)]
visited = [False] * (N+1)
distance = [0] * (N+1)

for i in range(M):
    A , B = list(map(int, s.readline().split()))
    graph[A].append(B)

def bfs(start):
    li = []
    queue = deque([start])
    visited[start] = True
    distance[start] = 0
    while queue:
        now = queue.popleft()
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                distance[i] = distance[now] +1
                if distance[i] == K:
                    li.append(i)
    if len(li) == 0 :
        print(-1)

    else:
        li.sort()
        for i in li:
            print(i, end='\n')



bfs(X)