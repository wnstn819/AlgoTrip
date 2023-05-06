from sys import stdin as s
from collections import deque
import time
M, N, H = map(int, s.readline().split())

dz = [0, -1, 0, 0, 1, 0]
dy = [0, 0, 1, 0, 0, -1]
dx = [1, 0, 0, -1, 0, 0]

tomato = [[list(map(int,s.readline().split())) for _j in range(N)] for _k in range(H)]
visited = [[[False for _i in range(M)] for _j in range(N)] for _k in range(H)]

days = 0
'''
이렇게 보면 층같이 보인다.
for i in tomato:
    print(i)
'''

# print(tomato)
queue = deque()

for _i in range(H):
    for _j in range(N):
        for _k in range(M):
            if tomato[_i][_j][_k] == 1 and visited[_i][_j][_k]:
                queue.append((_i, _j, _k))


while len(queue) != 0:
    z,y,x = queue.popleft()
    visited[z][y][x] = True
    for i in range(6):
        new_z = z + dz[i]
        new_y = y + dy[i]
        new_x = x + dx[i]

        # 범위 확인
        if new_z < 0 or new_z >= H or new_y < 0 or new_y >= N or new_x < 0 or new_x >= M:
            continue

        # 방문 확인
        if not visited[new_z][new_y][new_x] and tomato[new_z][new_y][new_x] == 0:
            queue.append([new_z, new_y, new_x])
            tomato[new_z][new_y][new_x] = tomato[z][y][x] + 1



for _i in range(H):
    for _j in range(N):
        for _k in range(M):
            if tomato[_i][_j][_k] == 0:
                print(-1)
                exit(0)    
        days = max(days, max(tomato[_i][_j]))

print(days-1)