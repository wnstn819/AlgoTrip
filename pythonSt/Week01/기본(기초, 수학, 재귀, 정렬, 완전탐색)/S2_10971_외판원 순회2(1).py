from sys import stdin as s
import sys

s = open('input.txt','rt')

N = int(s.readline())

test = [list(map(int,s.readline().split())) for _ in range(N)]


result = int(1e9)
def dfs(start,num,li):
    global result
    if len(li) == N:
        if test[num][start] > 0:
            li.append(test[num][start])
            temp = sum(li)
            result = min(result,temp)
            li.pop()
            return

    for i in range(N):
        if not visited[i] and test[num][i] != 0:
            visited[i] = True
            li.append(test[num][i])
            dfs(start,i,li)
            visited[i] = False
            li.pop()


for i in range(N):
    visited = [False] * N
    dfs(i,i,[])
print(result)