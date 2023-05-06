from sys import stdin as s
import heapq
s = open('input.txt','rt')

n = int(s.readline())

dp = [[i,int(1e9)] for i in range(n) ]+ [[n,0]] 



for i in range(n,1,-1):
    
        if dp[i-1][1] > dp[i][1]+1:
            dp[i-1][0] = i
            dp[i-1][1] = dp[i][1]+1
        

        if i % 2 == 0 and dp[i//2][1] > dp[i][1]+1:
            dp[i//2][0] = i
            dp[i//2][1] = dp[i][1]+1
    
        if i % 3 ==0 and dp[i//3][1] > dp[i][1]+1:
            dp[i//3][0] = i
            dp[i//3][1] = dp[i][1]+1


q = []
t = 1
print(dp[1][1])

index = 1
for _ in range(dp[1][1]+1):
    q.append(index)
    index = dp[index][0]

for a in q[::-1]:
    print(a,end= ' ')
    