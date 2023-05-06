from sys import stdin as s
import sys
sys.setrecursionlimit(10**5)
N , M = list(map(int,s.readline().split()))

arr = [list(map(int, s.readline().split())) for _ in range(N)]


dx = [ (0,1),(1,0), (-1,0),(0,-1)]





def DFS(x,y):
    if x == N-1 or y == M-1:
        return
    
    visited[x][y] = True
    for i in range(4):
        hx = x + dx[i][0]
        hy = y + dx[i][1]
        if hx < N-1 and hy < M-1 and not visited[hx][hy] and arr[hx][hy] > 0 :
            visited[hx][hy] = True
            DFS(hx,hy)



result =0
visited = [([False] * M) for _ in range(N)]
box = [([0]*M) for _ in range(N)]
while True:
    count =0

    for i in range(1,N):
        for j in range(1,M):
            if not visited[i][j] and arr[i][j] > 0:
                DFS(i,j)
                count += 1

    if count == 0 :
        print(0)
        break
    elif count > 1:
        print(result)
        break
    
    for i in range(1,N):
        for j in range(1,M):
            cnt = 0
            if (arr[i][j] != 0):
                if arr[i][j+1] == 0: cnt+=1
                if arr[i+1][j] == 0: cnt+=1
                if arr[i-1][j] == 0: cnt+=1
                if arr[i][j-1] == 0: cnt+=1
            box[i][j] = cnt

    for i in range(1,N):
        for j in range(1,M):
            if visited[i]:
                arr[i][j] = arr[i][j] - box[i][j]
                if arr[i][j] < 0 : arr[i][j] = 0
                box[i][j] = 0
                visited[i][j] = False
            
    result +=1

    


    






