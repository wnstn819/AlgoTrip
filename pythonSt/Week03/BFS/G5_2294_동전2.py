from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

n, k = map(int, s.readline().split())

arr = [int(s.readline()) for _ in range(n)]


#### DFS 시간 초과
# result = int(1e9)
# def DFS(start,depth):
#     global result
#     if start == k:
#         result = min(result,depth)
#         return

#     if start > k :
#         return
    
#     for i in arr:
#         DFS(start+i,depth+1)
    



# DFS(0,0)

# print(result)



# def BFS():
#     q = deque()
#     q.append((0,0))
#     while q:
#         start , depth = q.popleft()

#         for i in arr:
#             if start+i < k:
#                 q.append((start+i,depth+1))
#             elif start+i == k:
#                 print(depth+1)
#                 exit()
#             else :
#                 continue
        


# BFS()

dp = [0] * (k+1)
for i in range(1, k+1):
    tmp = []
    for coin in arr:
        if i>= coin and dp[i-coin] != -1:
            tmp.append(dp[i-coin]+1)
    if not tmp:
        dp[i] = -1
    else:
        dp[i] = min(tmp)


print(dp[k])