from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

dp = [0] * (n+1)

grape = [int(s.readline()) for _ in range(n)]


if n > 0:
    dp[0] = grape[0]
if n > 1:
    dp[1] = grape[0] + grape[1]
if n > 2:
    dp[2] = max(grape[2]+grape[1], grape[2]+grape[0],dp[1])


for i in range(3,n):
    dp[i] = max(grape[i]+grape[i-1]+dp[i-3],grape[i]+dp[i-2],dp[i-1])


print(dp[n-1])

