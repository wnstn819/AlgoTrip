from sys import stdin as s
from collections import deque

n = int(s.readline())

arr = [list(map(str.rstrip, s.readline().split())) for i in range(n)]

stack = deque()

for i in arr:
    if i[0] == 'push':
        stack.append(i[1])
    elif i[0] == 'pop':
        if stack:
            print(stack.popleft())
        else:
            print('-1') 
    elif i[0] == 'front':
        if stack:
            print(stack[0])
        else:
            print("-1")
    elif i[0] == 'back':
        if stack:
            print(stack[len(stack)-1])
        else:
            print("-1")
    elif i[0] == 'size':
        print(len(stack))
    elif i[0] == 'empty':
        if stack:
            print("0")
        else:
            print("1")
