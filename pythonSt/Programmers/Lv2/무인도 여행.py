from collections import deque


def BFS(start,end,visited,island):
    q = deque()
    q.append((start,end))
    visited[start][end] = True
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    result = int(island[start][end])
    while q :
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=ny< len(island[0]) and 0<=nx<len(island) and not visited[nx][ny] and island[nx][ny] !='X':
                visited[nx][ny] = True
                q.append((nx,ny))
                result += int(island[nx][ny])
                
                
    return result
                
        
    

def solution(maps):
    
    answer = []
    island = [list(map(str,maps[i])) for i in range(len(maps))]
    visited = [[False] * len(island[0]) for _ in range(len(island))]
    

    
    for i in range(len(island)):
        for j in range(len(island[0])):
            if island[i][j] != 'X' and not visited[i][j]:
                answer.append(BFS(i,j,visited,island))
    
    if answer:
        answer.sort()
    else:
        answer.append(-1)
    
                
    return answer