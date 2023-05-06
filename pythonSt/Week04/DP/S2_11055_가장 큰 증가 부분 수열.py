from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))
dp = arr[:]
for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i],dp[j]+arr[i])



print(arr)
print(dp)
print(max(dp))



