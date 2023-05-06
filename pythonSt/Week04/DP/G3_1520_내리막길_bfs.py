from sys import stdin as s
import heapq
s = open('input.txt','rt')

N ,M = map(int,s.readline().split())

arr = [list(map(int,s.readline().split())) for _ in range(N)]
dp = [[0] * M for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]


def bfs(now, x,y):
    q = []
    heapq.heappush()


print(bfs(0,0))
