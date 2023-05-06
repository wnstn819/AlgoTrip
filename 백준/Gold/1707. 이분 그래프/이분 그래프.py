from sys import stdin as s
from collections import deque

K = int(s.readline())


def BFS(start):
    global result
    q = deque()
    q.append(start)
    check[start] = 1
    while q :
        a = q.popleft()
        if graph.get(a) != None:
            for i in graph[a]: 
                if  check[i] == 0 :
                    q.append(i)
                    check[i] = -check[a]

                if  check[i] != 0 and check[i] == check[a] :
                    result = "NO"
                    break







for _ in range(K):
    global result
    graph = {}
    V, E = list(map(int,s.readline().split()))
    check = [0 for _ in range(V+1)]
    result = "YES"
    for _ in range(E):
        u, v = list(map(int,s.readline().split()))
        if graph.get(u) != None:
            graph[u].append(v)
        else:
            graph[u] = [v]

        if graph.get(v) != None:
            graph[v].append(u)
        else:
            graph[v] = [u]

    for i in range(1,V+1):
        if result == "NO":
            break;
        if check[i] == 0:
            BFS(i)

    print(result)

    