from sys import stdin as s
import sys
from collections import deque
sys.setrecursionlimit(100000)

s = open('input.txt','rt')


dx = [0,1,0,-1]
dy = [1,0,-1,0]
    
n = int(s.readline())

array = [list(map(int, s.readline().split())) for _ in range(n)]

result =0

def bfs(x,y,depth):
    queue = deque()
    queue.append((x,y))
    visited[x][y]= True
    while queue:
        hx,hy= queue.popleft()
        for i in range(4):
            nx = hx + dx[i]
            ny = hy + dy[i]
            if 0 <= nx < n and 0<= ny < n and array[nx][ny] > depth and not visited[nx][ny]:
                queue.append((nx,ny))
                visited[nx][ny] = True

            



#for i in range(max(map(max,array))):
for k in range(max(map(max,array))):
    visited = [[False] * n for _ in range(n)]
    ans =0
    for i in range(n):
        for j in range(n):  
            if not visited[i][j] and array[i][j] > k:
                ans +=1
                bfs(i,j,k)

    result =max(result,ans)


print(result)
# def dfs():


