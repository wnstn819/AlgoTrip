from sys import stdin as s
from collections import deque

s = open('input.txt','rt')


N, M = list(map(int,s.readline().split()))

#N 세로
#M 가로
arr = [list(map(str,s.readline().rstrip())) for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]
visited = [[False]*M for _ in range(N)]

result =0
def BFS(x,y,t):
    q = deque()
    q.append((x,y,t))
    visited[x][y] = True
    while q:
        hx , hy , type = q.popleft()
        if type == "-":
            for i in range(0,2):
                nx = hx +dx[i]
                ny = hy +dy[i]
                if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and arr[nx][ny] == "-":
                    q.append((nx,ny,"-"))
                    visited[nx][ny] = True

        else :
            for i in range(2,4):
                nx = hx +dx[i]
                ny = hy +dy[i]
                if 0<=nx<N and 0<=ny<M and not visited[nx][ny] and arr[nx][ny] == "|":
                    q.append((nx,ny,"|"))
                    visited[nx][ny] = True
        


for i in range(N):
    for j in range(M):
            if not visited[i][j]:
                BFS(i,j,arr[i][j])
                result +=1



print(result)