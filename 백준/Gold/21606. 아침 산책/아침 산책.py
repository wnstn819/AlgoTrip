from sys import stdin as s

n = int(s.readline())

check = [0] +list(map(str,s.readline().rstrip()))


graph = {}

for i in range(n-1):
    u , v = list(map(int,s.readline().split()))
    graph[u] = graph.get(u,[]) + [v]
    graph[v] = graph.get(v,[]) + [u]


def DFS(start,depth):
    global count
    if int(check[start]) == 1 and depth != 0:
        count +=1
        return
    visited[start] = True

    for i in graph[start]:
        if not visited[i]:
            DFS(i,depth+1)
    


count = 0

for i in range(1,n+1):
    visited = [False] + [False] * n
    if int(check[i]) == 1:
        DFS(i,0)


print(count)