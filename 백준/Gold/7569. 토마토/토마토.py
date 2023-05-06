from sys import stdin as s
from collections import deque
import time
M , N , H = list(map(int,s.readline().split()))

arr = [[list(map(int,s.readline().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]

queue = deque()

dh = [0,0,0,0,-1,1]
dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]

answer = 0

def bfs():
    while queue:
        x,y,z = queue.popleft()

        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dh[i]

            if nx < 0 or nx >= H or ny < 0 or ny >= N or nz < 0 or nz >= M:
                continue

            if arr[nx][ny][nz] == 0 and visited[nx][ny][nz] == False:
                queue.append((nx,ny,nz)) 
                arr[nx][ny][nz] = arr[x][y][z] +1
                visited[nx][ny][nz] = True



if __name__ == "__main__" :

    for a in range(H):
        for b in range(N):
            for c in range(M):
                if arr[a][b][c] == 1 and visited[a][b][c] == False:
                    queue.append((a,b,c))
                    visited[a][b][c] = True

    bfs()


    for a in arr:
        for b in a:
            for c in b:
                if c == 0 :
                    print(-1)
                    exit()
            answer = max(answer,max(b))

    print(answer - 1)



            




