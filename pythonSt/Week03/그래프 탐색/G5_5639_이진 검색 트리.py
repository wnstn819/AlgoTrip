from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')

arr = list(map(int,s.readlines()))

# graph = {}



# root = arr[0]


# def getTree(num,parent):
#     if num >= len(arr):
#         return

#     if arr[num] < parent:
#         if graph.get(parent) != None:    
#             getTree(num,graph[parent][0])
#         else:
#             graph[parent] = [arr[num],0]

#     else :
#         if graph.get(parent) != None:
#             if graph[parent][1] == 0:
#                 graph[parent][1] = arr[num]
#             else:
#                 getTree(num,graph[parent][1])
#         else:
#             graph[parent] = [0,arr[num]]


# for i in range(1,len(arr)):
#     getTree(i,root)

# def postOrder(num):
#     if num == 0 :
#         return
    
#     if  graph.get(num) != None:
#         postOrder(graph[num][0])
#         postOrder(graph[num][1])
        
#     print(num)


# postOrder(root)
    

# dfs 탐색
def dfs(start, end):

    # 시작과 끝 값이 역전시 리턴
    if start > end:
        return

    temp = end + 1

    # 서브 트리 찾기
    for i in range(start + 1, end + 1):
        # 루트 보다 크면 오른쪽 서브 트리
        if graph[start] < graph[i]:
            temp = i
            break

    dfs(start + 1, temp - 1) # 왼쪽 서브 트리 재귀적으로 탐색
    dfs(temp, end) # 오른쪽 서브 트리 재귀적으로 탐색
    print(graph[start])


# 입력이 없을때까지 반복하여 입력을 리스트에 추가한다.
graph = arr

dfs(0, len(graph) - 1)


