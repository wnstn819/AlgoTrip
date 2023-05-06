from sys import stdin as s

n  = int(s.readline())
list = list(map(int,s.readline().split()))
visited = [False] * n
total = 0
def dfs(li):
    global total
    if len(li) == n:
        sum = 0
        for i in range(n-1):
            sum += abs(li[i] - li[i+1])
        total = max(total,sum)
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            li.append(list[i])
            dfs(li)
            visited[i] = False
            li.pop()


dfs([])

print(total)





