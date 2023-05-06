from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)
s = open('input.txt','rt')

V,E = list(map(int,s.readline().split()))

graph = {}

for i in range(E):
    A, B ,C = list(map(int,s.readline().split()))
    if graph.get(A) == None or graph.get(B) == None:
        graph[A] = [(B,C)]
        graph[B] = [(A,C)]
    else:
        graph[A].append((B,C))
        graph[B].append((A,C))


visited = [False] * (V+1)

result = int(1e9)

def dfs(start,li,temp):
    global result
    if len(li)== 4:
        result = min(result, sum(li))
        print(li)
        return
    visited[start] = True

    if graph.get(start) != None:
        for i,j in graph[start]:
            
                temp += j
                li.append(j)
                dfs(i,li,temp)
                li.pop()
                temp -= j



for i in range(1,V+1):
    dfs(i,[],0)


print(result)
