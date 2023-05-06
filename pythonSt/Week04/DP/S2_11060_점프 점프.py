from sys import stdin as s

s= open('input.txt','rt')

n = int(s.readline())
arr = list(map(int,s.readline().split()))
dp = [-1] * (n)

dp[0] = 0

for i in range(n):
    if arr[i] == 0 or dp[i] == -1:
        continue
    for j in range(1,arr[i]+1):

        if i+j<n and (dp[i+j] == -1 or dp[i+j] > dp[i]+1):
            dp[i+j] = dp[i]+1


print(dp[n-1])
    




