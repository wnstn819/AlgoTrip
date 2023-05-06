from sys import stdin as s
s= open('input.txt','rt')

n = int(s.readline())

dp = [0] * (1001)


dp[0] = 0
dp[1] = 1
dp[2] = 2
for i in range(3,n+1):
    dp[i] = (dp[i-2] + dp[i-1]) % 10007

print(dp[n])

