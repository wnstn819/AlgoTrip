from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
#visited = [False] * N
li = []
def dfs(num,li):
    if len(li) == M:
        for i in li:
            print(i+1, end=" ")
        print()
        return

    for i in range(num,N):
        li.append(i)
        dfs(i,li)
        li.pop()


dfs(0,li)