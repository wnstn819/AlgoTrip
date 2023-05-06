## 시간 초과지만 테스트 케이스는 정확하게 구현해서 뿌듯함

from sys import stdin as s

s = open('input.txt','rt')
global r
global c
global count
N, r, c = map(int, s.readline().split())


dx = [0,0, 1, 0]
dy = [0,1, -1, 1]

count =0

def number(size,x,y):
    global count
    # if size != 4:
    #     number(size//4,x,y)

    if size == 1:
             for i in range(4):
                x = x + dx[i]
                y = y + dy[i]
                count += 1
                if  x == r and y == c :
                    print(count -1)
                    return
    locationX = x
    locationY = y
    
    for i in range(4):
        locationX = locationX + dx[i]*(2 ** (size-1))
        locationY = locationY + dy[i]*(2 ** (size-1))
        if (locationX <= r and locationY <= c):
            if( locationX + 2**(size-1) > r and locationY + 2**(size-1) > c):
                number( size -1, locationX, locationY)
            else:
                count += 2**(size-1)*2**(size-1)
                
           
        

    




number( N, 0 ,0)