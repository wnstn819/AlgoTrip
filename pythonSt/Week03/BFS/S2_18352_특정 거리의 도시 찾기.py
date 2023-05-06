from sys import stdin as s
from collections import deque


s = open('input.txt','rt')

N, M, K, X = list(map(int,s.readline().split()))

graph = {}
visited = [False] * (N+1)


def BFS(start):
    q = deque()
    q.append((start,0))
    visited[start] = True
    li = []
    while q:
        a,dis = q.popleft()

        if dis == K:
            li.append(a)

        

        if graph.get(a) != None:
            for i in graph[a]:
                if not visited[i] and dis+1 <= K:
                    q.append((i,dis+1))

                    visited[i] = True
                
                
    if len(li) == 0:
        print("-1")
    else:
        li.sort()
        for i in li:
            print(i)




for i in range(M):
    A,B = list(map(int,s.readline().split()))
    graph[A] = graph.get(A,[]) + [B]



BFS(X)