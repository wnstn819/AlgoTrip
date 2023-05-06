from sys import stdin as s
from collections import deque
n = int(s.readline())

arr = list(map(int,s.readline().split()))

stack = deque()

check = [0] * n

for i in range(n):
    if not stack:
        stack.append((i,arr[i]))
        continue
    
    while stack and stack[-1][1]< arr[i]:
        stack.pop()

    if not stack:
        check[i] = 0
    else :
        check[i] = stack[-1][0]+1
        

    stack.append((i,arr[i]))


for i in check:
    print(i, end=' ')