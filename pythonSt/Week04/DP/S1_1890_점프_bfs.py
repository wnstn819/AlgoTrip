from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

n = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1


count =0
def bfs(x,y):
    global count
    q = deque()
    q.append((x,y))

    while q:
        a,b = q.popleft()
        
        nx = a+arr[a][b]
        ny = b+arr[a][b]

        if 0<= ny< n :
            if arr[a][ny] ==0:
                count+=1
            else:
                q.append((a,ny)) 
        if 0<= nx < n:
            if arr[nx][b] ==0:
                count+=1
            else: q.append((nx,b))




bfs(0,0)


print(count)