from sys import stdin as s
import sys
sys.setrecursionlimit(100000)

s = open('input.txt','rt')


dx = [0,1,0,-1]
dy = [1,0,-1,0]

def safeArea(num,x,y):    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if  (0 <= nx < n) and (0 <= ny < n) and not visited[nx][ny] and array[nx][ny] > num:
            visited[nx][ny] = True
            safeArea(num,nx,ny)
    
   
        
    
n = int(s.readline())

array = [list(map(int, s.readline().split())) for _ in range(n)]



result =0
for k in range(max(map(max, array))):
    visited = [[False] * n for _ in range(n)]
    ans = 0
    for i in range(n):
        for j in range(n):
            if array[i][j] > k and not visited[i][j]:
                ans+=1
                visited[i][j] = True
                safeArea(k,i,j)

    result = max(result,ans)


print(result)