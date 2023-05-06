from sys import stdin as s
import sys

s = open('input.txt','rt')

N = int(s.readline())

test = [list(map(int,s.readline().split())) for _ in range(N)]
                                                                                                                                                 
global result
result = sys.maxsize
def dfs(num,start):
    global result
    if len(li) == N-1:
        if(test[num][start] != 0) :   
            li.append(test[num][start])
            result = min(result,sum(li))
            li.pop()
       

    visited[num] = True
    for i in range(N):
        if not visited[i] and test[num][i] != 0:
            visited[i] = True
            li.append(test[num][i])
            dfs(i,start)
            visited[i] = False
            li.pop()



for i in range(N):
    li = []
    visited = [False] * N
    dfs(i,i)


print(result)
