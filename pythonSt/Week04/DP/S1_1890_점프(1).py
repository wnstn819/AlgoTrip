from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if arr[i][j] != 0 and j+arr[i][j] <n:
            dp[i][j+arr[i][j]] += dp[i][j]
        if arr[i][j] != 0 and i+arr[i][j] < n:
            dp[i+arr[i][j]][j] += dp[i][j]

print(dp[n-1][n-1])



