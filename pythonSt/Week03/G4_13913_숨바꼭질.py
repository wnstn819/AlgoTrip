# from sys import stdin as s
# from collections import deque
# import sys
# sys.setrecursionlimit(10**6)

# s = open('input.txt','rt')

# N, K = map(int,s.readline().split())

# def BFS():
#     q = deque()
#     q.append((N,0,[N]))

#     while q:
#         a,depth,arr = q.popleft()
#         if a == K:
#             print(depth)
#             for i in arr:
#                 print(i, end= ' ')
#             break
#         for i in range(3):
#             if i == 0:
#                 q.append((a-1,depth+1,arr+[a-1]))
#             elif i == 1:
#                 q.append((a+1,depth+1,arr+[a+1]))
#             else: 
#                 q.append((a*2,depth+1,arr+[a*2]))
                




    
# BFS()






from sys import stdin as s
from collections import deque

s = open('input.txt','rt')


def path(x):
    arr = []
    temp = x
    for _ in range(dist[x]+1):
        arr.append(temp)
        temp = move[temp]
    print(' '.join(map(str, arr[::-1])))

def bfs():
    q = deque()
    q.append(N)
    while q:
        x = q.popleft()
        if x == K:
            print(dist[x])
            path(x)
            return x
        for i in (x+1, x-1, 2*x):
            if 0<=i<=100000 and dist[i]==0:
                q.append(i)
                dist[i] = dist[x] + 1
                move[i] = x

N, K = map(int, s.readline().split())
dist = [0]*100001
move = [0]*100001
bfs()