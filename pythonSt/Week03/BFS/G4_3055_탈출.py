from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

R, C = list(map(int,s.readline().split()))

BeaverMap = [list(map(str,s.readline().rstrip())) for _ in range(R)]
visited = [[0] * C for _ in range(R)]


# S = 1
# D = -1
# * = -2
# X = -3

q = deque()
startX, startY =0, 0
for i in range(R):
    for j in range(C):
        if BeaverMap[i][j] == "D":
            visited[i][j] = -1
        elif BeaverMap[i][j] == "*":
            q.appendleft((i,j,-2))
            visited[i][j] = -2
        elif BeaverMap[i][j] == "X":
            visited[i][j] = -3
        elif BeaverMap[i][j] == "S":
            q.append((i,j,1))
            visited[i][j] = 1

result =0


def BFS():
    global result
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    find = False
    while q:
        x,y,val = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < R and 0<= ny < C and (visited[nx][ny] == 0 or visited[nx][ny] == -1):
                if val == -3:
                    continue
                elif val == -1:
                    continue
                elif val == -2:
                    if visited[nx][ny] == -1:
                        continue
                    q.append((nx,ny,val))
                    visited[nx][ny] = -2
                else : 
                    if visited[nx][ny] == -1:
                        result = visited[x][y]
                        find = True
                        break
                    q.append((nx,ny,visited[x][y] +1))
                    visited[nx][ny] = visited[x][y] +1
                
        if find:
            break
    



BFS()

print('KAKTUS' if result == 0 else result)
        

        





