from sys import stdin as s
from collections import deque
import heapq

N , K = map(int,s.readline().split())

arr = [list(map(int,s.readline().split())) for _ in range(N)]

S, X ,Y = map(int,s.readline().split())

visited = [[False] * N for _ in range(N)]

queue = deque()
nextQueue = []

dx = [0,0,1,-1]
dy = [1,-1,0,0]



def BFS():

    while queue:
        #number, x, y, time = heapq.heappop(queue)
        number,x,y ,time = queue.popleft()
        if time > S:
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N and not visited[nx][ny] and time < S:
                queue.append((number,nx,ny,time+1))
                #heapq.heappush(nextQueue,(number,nx,ny,time+1))
                arr[nx][ny] = number
                visited[nx][ny] = True

        
        # if not queue:
        #     while nextQueue:
        #         heapq.heappush(queue,heapq.heappop(nextQueue))

temp = []


for i in range(N):
    for j in range(N):
        if arr[i][j] != 0:
            visited[i][j] = True
            temp.append((arr[i][j],i,j,0))
            #heapq.heappush(queue,(arr[i][j],i,j,0))
            


temp.sort()
for i in temp:
    queue.append((i[0],i[1],i[2],0))


BFS()

print(arr[X-1][Y-1])
