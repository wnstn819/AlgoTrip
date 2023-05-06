from sys import stdin as s

s= open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

dp = [1] * (n)

for i in range(n):
    for j in range(0,i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i],dp[j]+1)

print(max(dp))