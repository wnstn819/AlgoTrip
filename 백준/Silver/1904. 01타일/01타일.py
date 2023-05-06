from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

n = int(s.readline())

dp = [0] * 1000001
dp[1] = 1
dp[2] = 2


for k in range(3,n+1):
    dp[k] = (dp[k-1]+dp[k-2])%15746

print(dp[n])




        