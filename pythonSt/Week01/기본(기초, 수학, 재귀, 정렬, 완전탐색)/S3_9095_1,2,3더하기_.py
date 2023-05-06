from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')

n = list(map(int,s.readlines()))


def dfs(num,li):
    global count
    if sum(li) == num:
        count +=1
        return
    
    if sum(li) > num+3:
        return

    for i in range(1,4):
        li.append(i)
        dfs(num,li)
        li.pop()
        

for i in n[1:]:
    count = 0
    dfs(i,[])
    print(count)
