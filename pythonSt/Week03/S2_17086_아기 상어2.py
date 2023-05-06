from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

N,M = list(map(int,s.readline().split()))


arr = [list(map(int,s.readline().split())) for _ in range(N)]


result =0
def bfs(x,y):
    global result
    q = deque()
    q.append((x,y))
    dx = [0,1,0,-1,  1,1,-1,-1]
    dy = [1,0,-1,1,  1,-1,1,-1]
    while q:
        hx ,hy, = q.popleft()
        for i in range(8):
            nx = hx + dx[i]
            ny = hy + dy[i]
            if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and arr[nx][ny] != 1:
                q.append((nx,ny))
                visited[nx][ny] = True
                arr[nx][ny] = arr[hx][hy] + 1




for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            visited = [[False] * (M) for _ in range(N)]
            bfs(i,j)


print(arr)
