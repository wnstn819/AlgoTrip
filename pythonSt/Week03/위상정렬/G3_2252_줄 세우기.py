from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

N , M = map(int,s.readline().split())

graph = [[] for _ in range(N+1)]
indegree = [0] * (N+1)

for _ in range(M):
    u, v = map(int,s.readline().split())
    graph[u].append(v)
    indegree[v] += 1


def BFS():
    result =[]
    q = deque()
    
    for i in range(1,N+1):
        if indegree[i] == 0 :
            q.append(i)
    

    while q:
        a = q.popleft()
        result.append(a)
        for i in graph[a]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
            

        
    for i in result:
        print(i, end=' ')



BFS()




