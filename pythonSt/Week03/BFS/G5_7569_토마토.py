from sys import stdin as s
from collections import deque

s =open('input.txt','rt')

M , N , H = list(map(int,s.readline().split()))

arr = [[list(map(int,s.readline().split())) for _ in range(N)] for _ in range(H)]
visited = [[[False] * M for _ in range(N)] for _ in range(H)]

#print(arr[1][1][2]) # 0 ~ 1, 2 이렇게 쌓임


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
        for i in range(N):
            for j in range(M):
                print(arr[h][i][j],end=" ")
                if arr[h][i][j] == -1:
                    minus -= 1
                elif arr[h][i][j] == 1:
                    count += 1
                print("x : " ,h,i,j ,"count : ", count)
                if arr[h][i][j] == 1 and not visited[h][i][j]:
                    for v in range(6):
                        nh = h + dh[v]
                        nx = i + dx[v]
                        ny = j + dy[v]
                        if 0<=nh<H and 0<=nx<N and 0<=ny<M and not visited[nh][nx][ny] and arr[nh][nx][ny] != -1:
                            visited[nh][nx][ny] = True
                            arr[nh][nx][ny] = 1
                    result+=1
            print()
                

    print(arr)
    print("count : ", count)
    print("minus : ", minus)
    
    if count == (H*M*N)+minus:
        print(result)
        break
    
    if prev == count:
        print(prev)
        print("-1")
        break
    else:
        prev = count






            




