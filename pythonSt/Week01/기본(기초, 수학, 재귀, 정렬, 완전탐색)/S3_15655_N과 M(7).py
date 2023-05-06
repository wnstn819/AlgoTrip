from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
list = list(map(int, s.readline().split()))
li = []

list = sorted(list)

def dfs(li):
    if len(li) == M:
        for i in li:
            print(i, end=" ")
        print()
        return

    for i in range(N):
        li.append(list[i])
        dfs(li)
        li.pop()

dfs(li)