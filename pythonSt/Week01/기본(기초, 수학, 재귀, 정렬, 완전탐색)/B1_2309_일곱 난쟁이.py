from sys import stdin as s

global count

s = open('input.txt','rt')

key = list(map(int, s.readlines()))
temp =[]

def bfs(num, start):
    if num == 7:
        if sum(temp) == 100:
            for i in sorted(temp):
                print(i)
            exit()
        else : 
            return
    for i in range(start , 9):
        temp.append(key[i])
        bfs(num +1, i+1)
        temp.pop()



bfs(0,0)



    


