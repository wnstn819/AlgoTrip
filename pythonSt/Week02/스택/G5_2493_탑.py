from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

stack = deque()

check = [0] * n


# 시간 초과
# for i in range(n):
#     if i != 0 :
#         for j in range(len(stack)-1,-1,-1):
#             if arr[i] > stack[j][1] :
#                 stack.pop()
#                 stack.append((i,arr[i]))
#             else :
#                 stack.append((i,arr[i]))
#                 check[i] = stack[j][0]+1
#                 break

#     else :
#         stack.append((i,arr[i]))
    


for i in range(n):
    while stack:
        if stack[-1][1] > arr[i]:
            check[i] = stack[-1][0] +1
            break
        else:
            stack.pop()
    stack.append((i,arr[i]))
    




for i in check:
    print(i, end=" ")



