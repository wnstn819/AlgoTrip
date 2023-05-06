from sys import stdin as s
import sys
from collections import deque
sys.setrecursionlimit(10**6)

N, M, V = list(map(int,s.readline().split()))

graph = {}
visited = [False] * (N+1)

for i in range(M):
    a, b = list(map(int, s.readline().split()))
    if graph.get(a) == None :
        graph[a] = [b]
        
    else:
        graph[a].append(b)
    if graph.get(b) == None:
        graph[b] = [a]

    else: 
        graph[b].append(a)

    graph[a].sort()
    graph[b].sort()

def dfs(start, li):
    
    
    li.append(start)
    visited[start] = True
    if graph.get(start) != None:
        for i in range(len(graph[start])):
            if not visited[graph[start][i]]:
                dfs(graph[start][i],li)

    else :
        return
    
list = []

dfs(V,list)

for i in list:
    print(i, end= " ")
visited = [False] * (N+1)

def bfs(start):

    q = deque()
    q.append(start)
    visited[start] =True
    while q :
        a = q.popleft()    
        print(a, end=' ')
        if graph.get(a) == None:
            break
        for i in graph[a]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
        


print()

bfs(V)


