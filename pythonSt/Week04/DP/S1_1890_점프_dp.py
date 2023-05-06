from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

n = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if 0<= j+arr[i][j] <n and arr[i][j] != 0:
            dp[i][j + arr[i][j]] += dp[i][j]
        if 0<= i+arr[i][j] <n and arr[i][j] != 0:
            dp[i + arr[i][j]][j] += dp[i][j]

print(dp[n-1][n-1])