from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

N = int(s.readline())

arr = [[0] * N for _ in range(N)]

K = int(s.readline())


dQueue = deque([(0,1),(1,0),(0,-1),(-1,0)])

snake = deque()
snake.append((0,0))

time = 0
x , y =0, 0
arr[0][0] = 1
def move(dx, dy):
    global time
    global x, y
    if 0<= dx < N and 0<= dy < N:    
        if arr[dx][dy] == 3:
            snake.append((dx,dy))
            arr[dx][dy] = 1
            x, y= dx, dy
        elif arr[dx][dy] == 1:
            print(time + 1)
            exit(0)
        else:
            hx , hy =snake.popleft()
            arr[hx][hy] = 0
            snake.append((dx,dy))
            arr[dx][dy] = 1
            x , y = dx, dy

    else:
        print(time + 1 )
        exit(0)
    time +=1



def rotationD(rotation):
    if rotation == "D":
        hx , hy = dQueue.popleft()
        dQueue.append((hx,hy))
    else :
        hx, hy = dQueue.pop()
        dQueue.appendleft((hx,hy))

for _ in range(K):
    appleX, appleY = list(map(int,s.readline().split()))
    arr[appleX-1][appleY-1] = 3 ## 사과 위치 저장

L = int(s.readline())



for _ in range(L):
    rocTime, rotation = list(map(str.rstrip,s.readline().split()))
    while time < int(rocTime):
        dx = x + dQueue[0][0]
        dy = y + dQueue[0][1]
        move(dx,dy)

    rotationD(rotation)

while True:
    dx = x + dQueue[0][0]
    dy = y + dQueue[0][1]
    move(dx,dy)



