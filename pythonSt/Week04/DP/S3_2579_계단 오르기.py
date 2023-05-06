from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [int(s.readline()) for _ in range(n)]

dp = [0] * n

if len(arr)<=2:
    print(sum(arr))
else :
    dp[0] = arr[0]
    dp[1] = arr[0]+arr[1]
    for i in range(2,n):
        print(dp[i-3])
        dp[i] = max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i])
    
    print(dp[-1])

