from sys import stdin as s
from collections import deque

s= open('input.txt','rt')

N = int(s.readline())
M = int(s.readline())


amounts = [[] for _ in range(N+1)]
indegree = [0] * (N+1)
graph = [[] for _ in range(N+1)]
tables = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
starts =[]

for _ in range(M):
    start, end, cost = map(int,s.readline().split())
    amounts[end].append((start,cost))
    indegree[start] += 1

def BFS():
    q = deque()

    for i in range(1, N+ 1):
        if indegree[i] == 0:
            q.append(i)
            starts.append(i)

    while q:
        now = q.popleft()
        for amount in amounts[now]:
            e, c = amount
            # 기본부품 더하기
            if now in starts:
                tables[e][now] = c
            # 중간부품 더하기
            else:
                for i in range(1, N + 1):
                    tables[e][i] += tables[now][i] * c
            indegree[e] -= 1
            if indegree[e] == 0:
                q.append(e)



BFS()
for i in starts:
    print(i, tables[N][i])
