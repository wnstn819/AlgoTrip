from sys import stdin as s
from collections import deque

n, k = map(int, s.readline().split())

thing = [[0,0]]
d = [[0]*(k+1) for _ in range(n+1)]

for i in range(n):
    thing.append(list(map(int, s.readline().split())))

for i in range(1, n+1): # i -> 다른 짐
    for j in range(1, k+1): # j -> 허용되는 무게
        w = thing[i][0]
        v = thing[i][1]

        if j < w:
            d[i][j] = d[i-1][j]
        else:
            d[i][j] = max(d[i-1][j], d[i-1][j-w]+v)

print(d[n][k])