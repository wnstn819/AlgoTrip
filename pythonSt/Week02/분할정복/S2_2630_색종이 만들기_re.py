from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(n)]

white =0
blue = 0

def dfa(size,x,y):
    global white
    global blue
    if size == 1:
        if arr[x][y] == 1:
            blue +=1
            return
        else:
            white +=1
            return
    color= arr[x][y]
    divide = False
    for i in range(x,x+size):
        for j in range(y,y+size):
            if arr[i][j] != color:
                divide = True
                break
        if divide:
            break            

    
    if divide:
        dfa(size//2,x,y)
        dfa(size//2,x+size//2,y)
        dfa(size//2,x,y+size//2)
        dfa(size//2,x+size//2,y+size//2)
    else :
        if color == 1:
            blue +=1
        else: 
            white += 1

dfa(n,0,0)

print(white, blue)

    


