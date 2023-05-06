from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
list = list(map(int, s.readline().split()))
visited = [False] * N
li = []

list = sorted(list)

def dfs(li):
    if len(li) == M:
        for i in li:
            print(i, end=" ")
        print()

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            li.append(list[i])
            dfs(li)
            visited[i] = False
            li.pop()



dfs(li)