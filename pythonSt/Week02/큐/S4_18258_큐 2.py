from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

arr = [list(map(str.rstrip, s.readline().split())) for i in range(n)]

stack = deque()

for i in arr:
    if i[0] == 'push':
        stack.append(i[1])
    elif i[0] == 'front':
        if len(stack) > 0 :
            print(stack[0])
        else:
            print("-1")            
    elif i[0] == 'back':
        if len(stack) > 0 :
            print(stack[len(stack)-1])
        else:
            print("-1")            
    elif i[0] == 'size':
            print(len(stack))
    elif i[0] == 'pop':
            if len(stack) > 0 :
                print(stack.popleft())
            else:
                print("-1")               
    elif i[0] == 'empty':
        if len(stack) > 0 :
            print("0")
        else:
            print("1")            