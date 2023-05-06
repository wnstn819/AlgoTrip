from sys import stdin as s
import sys
sys.setrecursionlimit(10**9)

s = open('input.txt','rt')

n = int(s.readline())

check = [0] +list(map(str,s.readline().rstrip()))


graph = {}


count = 0


def DFS(start,depth):
    result = 0
    for i in graph[start]:
        # if not visited[i]:
        #     visited[start] = True
        #     if int(check[i]) == 1: count +=1 
        #     else:
        #         DFS(i,depth+1)
        if int(check[i]) == 0:
            if not visited[i]:
                visited[i]=True
                result += DFS(i,0)
        else: result += 1

    return result
    


for i in range(n-1):
    u , v = list(map(int,s.readline().split()))
    graph[u] = graph.get(u,[]) + [v]
    graph[v] = graph.get(v,[]) + [u]
    if int(check[u]) == 1 and int(check[v]) == 1:
        count +=2


visited = [False] + [False] * n

for i in range(1,n+1):
    ans = 0
    if int(check[i]) == 0:
        if not visited[i]:
            visited[i] = True
            ans = DFS(i,0)

    count += ans*(ans-1)

print(count)