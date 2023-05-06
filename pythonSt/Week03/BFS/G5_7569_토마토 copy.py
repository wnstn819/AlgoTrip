from sys import stdin as s
from collections import deque

s =open('input.txt','rt')

M , N , H = list(map(int,s.readline().split()))

arr = [[list(map(int,s.readline().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]

print(arr[1][1][2]) # 0 ~ 1, 2 이렇게 쌓임



def BFS(h,x,y,time):
    q = deque()
    q.append((h,x,y,time))
    visited[h][x][y] = True
    while q :
        hh,hx,hy,ht = q.popleft()
        

        for i in range(6):
            nh = hh + dh[i]
            nx = hx + dx[i]
            ny = hy + dy[i]
            if 0<=nh<H and 0<=nx<N and 0<=ny<M and not visited[nh][nx][ny]:
                

        








# BFS(0,0,0)


# 익히는 함수

# 익어있는지 확인하는 함수

dh = [0,0,0,0,1,-1]
dx = [0,1,0,-1,0,0]
dy = [1,0,-1,0,0,0]
prev = 0
result =0
while True:
    visited = [[[False] * M for _ in range(N)] for _ in range(H)]
    count = 0
    minus = 0
    for h in range(H):
        for i in range(M):
            for j in range(N):
                if not visited[H][M][N] and arr[H][M][N] == 1:
                    BFS(h,i,j,result)


    result +=1


            




