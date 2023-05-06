from sys import stdin as s

s = open('input.txt','rt')

N = int(s.readline())

arr = [list(map(int,s.readline().split())) for i in range(N)]

dp = [0 for i in range(N+1)]

for i in range(N):
    for j in range(i+arr[i][0], N+1):
        if dp[j] < dp[i] + arr[i][1]:
            dp[j] = dp[i] + arr[i][1]


print(dp[-1])