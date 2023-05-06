from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

board = [list(map(str,s.readline().rstrip())) for _ in range(N)]


# col =0 W
# col =1 B
result = int(1e9)
def check(x,y,col):
    q = deque()
    q.append((x,y))
    visited[x][y]= True
    dx = [0,1]
    dy = [1,0]  
    count =0
    if col == 0:
        if (x + y) % 2 == 0:
            if board[x][y] == "B":
                count+=1
        elif (x + y) % 2 == 1:
            if board[x][y] == "W":
                count+=1
    else :
        if (x + y) % 2 == 0:
            if board[x][y] == "W":
                count+=1
        elif (x + y) % 2 == 1:
            if board[x][y] == "B":
                count+=1
                
    while q :
        hx, hy = q.popleft()
        for i in range(2):
            nx = hx + dx[i]
            ny = hy + dy[i]
            
            if nx <= x+7 and ny <= y+7  and not visited[nx][ny]:
                q.append((nx,ny))
                visited[nx][ny] = True
                if col == 0:
                    if (nx + ny) % 2 == 0:
                        if board[nx][ny] == "B":
                            count+=1
                    elif (nx + ny) % 2 == 1:
                        if board[nx][ny] == "W":
                            count+=1
                else :
                    if (nx + ny) % 2 == 0:
                        if board[nx][ny] == "W":
                            count+=1
                    elif (nx + ny) % 2 == 1:
                        if board[nx][ny] == "B":
                            count+=1
                
    return count          
    

for i in range(N-7):
    for j in range(M-7):
            visited = [[False]* M for _ in range(N)]
            result = min(check(i,j,0),result)

            visited = [[False]* M for _ in range(N)]
            result = min(check(i,j,1),result)
          

print(result)    

