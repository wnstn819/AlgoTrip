# from sys import stdin as s
# import sys
# from collections import deque

# sys.setrecursionlimit(10**6)

# s = open('input.txt','rt')

# N, M = list(map(int,s.readline().split()))

# visited = [False] * (N+1)

# graph = {}

# for i in range(M):
#     u, v = list(map(int,s.readline().split()))
#     if graph.get(u) == None:
#         graph[u] = [v]
#     else:
#         graph[u].append(v)

#     if graph.get(v) == None:
#         graph[v] = [u]
#     else:
#         graph[v].append(u)

    


# def DFS(start):
#     if graph.get(start) == None:
#         return
    
#     visited[start] = True
#     for i in graph[start]:
#         if not visited[i]: 
#             visited[i] = True
#             DFS(i)


# def BFS(start):

#     q = deque()
#     q.append(start)
#     visited[start] = True
#     while q:
#         a = q.popleft()
#         if graph.get(a) != None:
#             for i in graph[a]:
#                 if not visited[i]:
#                     visited[i] = True
#                     q.append(i)

    
# count =0

# for i in range(1,N+1):
#     if not visited[i]:
#         DFS(i)
#         count +=1
    
# visited = [False] * (N+1)

# for i in range(1,N+1):
#     if not visited[i]:
#         BFS(i)
#         count +=1

# print(count)




    





# #for i in range(1,N+1):
# #   if not visited[i]:


from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')
N, M = list(map(int,s.readline().split()))

arr = [0] * (N+1)

for i in range(1,N+1):
    arr[i] = i


def union(a,b): # 결합
    a = find(a)
    b = find(b)

    if a < b:
        arr[b] = a
    else:
        arr[a] = b



def find(b): # 찾기

    if arr[b] != b:
        arr[b] = find(arr[b])

    return arr[b]

data =[]
for i in range(M):
    u ,v = list(map(int,s.readline().split()))
    data.append((u,v))


data.sort(key= lambda x: x[1])

for i,j in data:
    union(i,j)

tt=set(arr)
print(len(tt)-1)