from sys import stdin as s

s = open('input.txt','rt')

N, M = map(int, s.readline().split())
visited = [False] * N
li = []
def dfs(num,li):
    if len(li) == M:
        for i in li:
            print(i+1, end=" ")
        
        print()

    for i in range(num,N):
        if not visited[i]:
            visited[i] = True
            li.append(i)
            dfs(i,li)
            visited[i] = False
            li.pop()


dfs(0,li)