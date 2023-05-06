from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

array = [list(map(int,s.readline().split())) for _ in range(n)]
visited = [False] * n
result =int(1e9)

def dfs(depth,idx):
    global result
    if depth == n//2:
        power1,power2 = 0, 0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    power1 += array[i][j]
                elif not visited[i] and not visited[j]:
                    power2 += array[i][j]
        
        result = min(result, abs(power1-power2))
     
        return
    
    for i in range(idx,n):
        if not visited[i]:
            visited[i] = True
            dfs(depth+1,i+1)
            visited[i] = False


    
dfs(0,0)

print(result)


