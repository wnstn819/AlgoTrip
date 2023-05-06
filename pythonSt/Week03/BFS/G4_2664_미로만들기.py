from sys import stdin as s
from collections import deque


s = open('input.txt','rt')

n = int(s.readline())

arr = [list(map(str,s.readline().rstrip())) for _ in range(n)]


dx = [0 , 1 ,0 ,-1]
dy = [1, 0 ,-1 ,0]



    
def BFS():
    q = deque()
    q.append((0,0))
    visited = [[-1] * n for _ in range(n)]
    visited[0][0] = 0



    while q:
        x,y = q.popleft()

        if x == n-1 and y == n-1:
            return visited[x][y]  
        for i in range(4):
            hx = x + dx[i]
            hy = y + dy[i]
            if 0<=hx < n and 0<=hy<n and visited[hx][hy] == -1:
                if int(arr[hx][hy]) == 1:
                    q.appendleft((hx,hy))
                    visited[hx][hy] = visited[x][y]
                else:
                    q.append((hx,hy))
                    visited[hx][hy] = visited[x][y] + 1

            




print(BFS())