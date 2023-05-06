from sys import stdin as s

n = int(s.readline())

arr= list(map(int,s.readline().split()))
dp = [1] * n

for i in range(n):
    for j in range(i):
        if arr[i] < arr[j]:
            dp[i] = max(dp[j]+1,dp[i])


print(max(dp))