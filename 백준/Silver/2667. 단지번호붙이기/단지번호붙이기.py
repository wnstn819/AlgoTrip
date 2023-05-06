from sys import stdin as s
from collections import deque

n = int(s.readline())


arr = [list(map(str,s.readline().rstrip())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
result = []
test=0

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def BFS(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y]= True
    count = 1
    while q :
        a, b = q.popleft()

        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and arr[nx][ny] != "0":
                q.append((nx,ny))
                visited[nx][ny] = True
                count +=1

    result.append(count)
    

for i in range(n):
    for j in range(n):
        if not visited[i][j] and arr[i][j] != "0":   
            BFS(i,j)
            test +=1



print(test)
result.sort()
for i in result:
    print(i)
