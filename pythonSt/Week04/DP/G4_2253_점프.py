from sys import stdin
from math import sqrt

s = open('input.txt','rt')


def solve():
    N, M = map(int, s.readline().split())
    dp = [[float('inf')] * (int(sqrt(2*N))+2) for _ in range(N+1)]
    dp[1][0] = 0
    trap = set()
    for _ in range(M):
        trap.add(int(s.readline()))
    
    for i in range(2, N+1):
        if i in trap:
            continue
        for v in range(1, int(sqrt(2*i)) + 1): # v 범위를 제한 => 들어오는 i에 대해서만
            dp[i][v] = min(dp[i-v][v-1], dp[i-v][v], dp[i-v][v+1]) + 1
    
    result = min(dp[N])
    if result == float('inf'):
        print(-1)
    else:
        print(result)

solve()

# from sys import stdin as s

# s = open('input.txt','rt')

# N, M = map(int,s.readline().split())

# dp = [[1,int(1e9)] for _ in range(100001)]

# dp[1][1]= 1
# dp[2][1]= 1


# for _ in range(M):
#     a = int(s.readline())
#     dp[a][1] = 0

# # (속도, 횟수)
# for i in range(2,N):
#     # 속도가 -1일때
#     # 2 = 1
#     if dp[i][1] == 0:
#         continue
#     print(i,dp[i][0])
#     if dp[i][1]+1 <= dp[i+dp[i][0]-1][1]:
#         dp[i+dp[i][0]-1][1] =  dp[i][1]+1
#         dp[i+dp[i][0]-1][0] =  dp[i][0]-1

#     # 속도가 x일때
#     # 2 = 2 
#     if dp[i][1]+1 <= dp[i+dp[i][0]][1]:
#         dp[i+dp[i][0]][1] =  dp[i][1]+1
#         dp[i+dp[i][0]][0] =  dp[i][0]

#     # 속도가 x+1일때
#     # 2 = 3
#     if dp[i][1]+1 <= dp[i+dp[i][0]+1][1]:
#         dp[i+dp[i][0]+1][1] =  dp[i][1]+1
#         dp[i+dp[i][0]+1][0] =  dp[i][0]+1


# print(dp[N][1])