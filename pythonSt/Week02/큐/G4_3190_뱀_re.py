from sys import stdin as s
from collections import deque

dQ = deque([(0,1),(1,0),(0,-1),(-1,0)])
sQ = deque([(0,0)])
x, y =0, 0

count = 0
def move(sx,sy):
    global dQ
    global x
    global y
    global count
    dx = sx + dQ[0][0]
    dy = sy + dQ[0][1]
    if 0<= dx < N and 0<= dy < N and arr[dx][dy] != 1:
        if arr[dx][dy] == 3:
            sQ.append((dx,dy))
            arr[dx][dy] = 1
            x = dx
            y = dy
            count +=1
        else:
            sQ.append((dx,dy))
            a, b =sQ.popleft()
            arr[a][b] = 0
            arr[dx][dy] = 1
            x = dx
            y = dy
            count  +=1
    else:
        print(count+1)
        exit()




def rotationHead(rotation):
    if rotation == "D":
        dQ.append(dQ.popleft())
    else :
        dQ.appendleft(dQ.pop()) 



if __name__ == '__main__':
    s = open('input.txt','rt')
    N = int(s.readline())

    arr = [[0] * N for _ in range(N)]
    arr[0][0]= 1
    K = int(s.readline())



    for i in range(K):
        appleX, appleY = list(map(int, s.readline().split()))
        arr[appleX-1][appleY-1] = 3

    L = int(s.readline())
    

    for i in range(L):
        walk, rotation = map(str.rstrip, s.readline().split())
        for j in range(count,int(walk)):
            move(x,y)
        rotationHead(rotation)


    while True:
        move(x,y)



