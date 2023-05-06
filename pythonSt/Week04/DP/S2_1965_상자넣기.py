from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [0] + list(map(int,s.readline().split()))

dp = [0] + [1] * (n)


for i in range(1,n+1):
    for j in range(1,i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[j]+1,dp[i])




print(max(dp))
    

