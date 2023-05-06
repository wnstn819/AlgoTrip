from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

from sys import stdin as s
s = open('input.txt','rt')

N= int(s.readline())


### 3개의 경우의 수 - 왼쪽사자, 오른쪽 사자, 아무것도 안고를때
dp = [[0,0,0] for _ in range(N)]
dp[0] = [1,1,1]

for i in range(1,N):
    dp[i][0] = (dp[i-1][1] + dp[i-1][2])
    dp[i][1] = (dp[i-1][0] + dp[i-1][2])
    dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])


print(sum(dp[N-1]))