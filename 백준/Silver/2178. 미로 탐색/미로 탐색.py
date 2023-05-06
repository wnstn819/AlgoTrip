from sys import stdin as s
from collections import deque

N, M = list(map(int,s.readline().split()))

arr = [list(map(str,s.readline().rstrip())) for _ in range(N)]

visited = [[False] * M for _ in range(N)]

dx = [(0,1), (1,0), (0,-1), (-1,0)]



def BFS(x,y):
    q = deque()
    q.append((x,y,0))
    visited[x][y] = True
    while q:
        u,v,dis = q.popleft()
        if u == N-1 and v == M-1:
            print(dis+1)
        for i in range(4):
            hx = u + dx[i][0]
            hy = v + dx[i][1]
            if 0<= hx < N and 0<= hy < M and int(arr[hx][hy]) !=0 and not visited[hx][hy]:
                q.append((hx,hy,dis+1))
                visited[hx][hy] = True



BFS(0,0)
