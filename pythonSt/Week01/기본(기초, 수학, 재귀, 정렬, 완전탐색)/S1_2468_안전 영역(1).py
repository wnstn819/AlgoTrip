from sys import stdin as s
import sys
sys.setrecursionlimit(100000)

s = open('input.txt','rt')


dx = [0,1,0,-1]
dy = [1,0,-1,0]
    
n = int(s.readline())

array = [list(map(int, s.readline().split())) for _ in range(n)]



def dfs(x,y,depth):
    for i in range(4):
        if 0 <= x+dx[i] < n and 0 <= y+dy[i] < n  and array[x+dx[i]][y+dy[i]] > depth and visited[x+dx[i]][y+dy[i]]:
            visited[x+dx[i]][y+dy[i]] = False
            dfs(x+dx[i], y+dy[i], depth)


result =0

print(max(map(max,array)))
for k in range(max(map(max, array))):
    visited = [[True] * n for _ in range(n)]
    ans =0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == True and array[i][j] > k:
                ans+=1
                visited[i][j] = False
                dfs(i,j,k)

        result = max(ans,result)

print(result)
# def dfs():


