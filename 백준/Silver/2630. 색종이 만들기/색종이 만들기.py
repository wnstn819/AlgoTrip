from sys import stdin as s

n = int(s.readline())

arr = [list(map(int,s.readline().split())) for _ in range(n)]

white =0
blue = 0

def dfs(x,y,size):
    global white
    global blue
    if size == 1:
        if arr[x][y] == 1:
            blue +=1
            return
        else:
            white +=1
            return

    check = arr[x][y]
    divide = False
    for i in range(x,x+size):
        for j in range(y,y+size):
            if arr[i][j] != check:
                divide = True
                break
        if divide:
            break

    if divide:
        #나누기
        dfs(x,y,size//2)
        dfs(x,y+size//2 , size//2)
        dfs(x+size//2,y, size//2)
        dfs(x+size//2, y+size//2,size//2)

    else :
        if check == 1:
            blue+=1
        else :
            white +=1



dfs(0,0,n)

print(white)
print(blue)
