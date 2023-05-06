from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

N = int(s.readline())


def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    while q :
        a,b  = q.popleft()

        for i in range(4):
            nx= a + dx[i]
            ny= b + dy[i]
            if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and arr[nx][ny] == 1:
                q.append((nx,ny))
                visited[nx][ny]= True




for _ in range(N):
    M, N, K = list(map(int,s.readline().split()))
    visited = [[False] *  M for _ in range(N)]
    arr = [[0]* M for _ in range(N)]
    for _ in range(K):
        y, x = map(int,s.readline().split())
        arr[x][y] = 1

    
    count = 0
    for i in range(N):
        for j in range(M):    
            if not visited[i][j] and arr[i][j] == 1:
                bfs(i,j)
                count +=1


    print(count)



