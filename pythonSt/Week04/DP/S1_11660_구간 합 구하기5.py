from sys import stdin as s

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

arr = [list(map(int,s.readline().split())) for _ in range(N)]
dp = [[0]* (N+1) for _ in range(N+1)]

temp = [list(map(int,s.readline().split())) for _ in range(M)]

for i in range(1,N+1):
    for j in range(1,N+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1]


for x1,y1,x2,y2 in temp:
    result = dp[x2][y2]- dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]
    print(result)