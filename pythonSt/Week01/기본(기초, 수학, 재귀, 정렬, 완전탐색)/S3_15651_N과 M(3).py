from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
#visited = [False] * N
li = []
def dfs(li):
    if len(li) == M:
        for i in li:
            print(i+1, end=" ")
        print()
        return

    for i in range(N):
        li.append(i)
        dfs(li)
        li.pop()


dfs(li)