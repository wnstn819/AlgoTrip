from sys import stdin as s
from copy import deepcopy

s = open('input.txt','rt')

N,  M = map(int,s.readline().split())

arr = [list(map(int,s.readline().split())) for _ in range(N)]
dp = deepcopy(arr)

dx = [1,0,1]
dy = [0,1,1]


for i in range(N):
    for j in range(M):
        for k in range(3):
            nx = i+dx[k]
            ny = j+dy[k]
            if 0<=nx<N and 0<=ny<M :
                dp[nx][ny] = max(dp[i][j]+arr[nx][ny],dp[nx][ny])


print(dp[N-1][M-1])
