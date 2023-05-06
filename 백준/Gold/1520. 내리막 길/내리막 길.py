from sys import stdin as s
N ,M = map(int,s.readline().split())

arr = [list(map(int,s.readline().split())) for _ in range(N)]
dp = [[-1] * M for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def dfs(x,y):

    if x == N-1 and y == M-1:
        return 1
    if dp[x][y] != -1:
        return dp[x][y]

    dp[x][y] = 0
    for z in range(4):
        nx = x+ dx[z]
        ny = y + dy[z]
        if 0<= nx < N and 0<= ny <M:
            if arr[nx][ny] < arr[x][y]:
                dp[x][y] += dfs(nx,ny)
            
        
    return dp[x][y]
            

print(dfs(0,0))
