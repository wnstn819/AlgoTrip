from sys import stdin as s
from collections import deque
import copy

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

array = [list(map(str,s.readline().rstrip())) for _ in range(N)]

dx = [0,-1,0,1]
dy = [1,0,-1,0]
global result
result =0
def bfs(x,y):
    global result
    maps = [item[:] for item in array]
    h = 0
    q = deque()
    q.append((x,y,h))
    maps[x][y] = 'W'
    ans = 0
    while q:
        hx ,hy,hh = q.popleft()
        ans = max(ans,hh)
        for i in range(4):
            nx = hx + dx[i]
            ny = hy + dy[i]
            nh = hh
            if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] != 'W':
                maps[nx][ny] = 'W'
                q.append((nx,ny,nh+1))
                
    
    return ans

for i in range(N):
    for j in range(M):
        if array[i][j] == "L":
            if i> 0 and i+1<N and array[i-1][j] == "L" and array[i+1][j] =="L":
                continue
            if j> 0 and j+1<M and array[i][j-1] == "L" and array[i][j+1] =="L":
                continue
            result = max(result,bfs(i,j))
        

print(result)