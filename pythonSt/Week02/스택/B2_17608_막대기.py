from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

stack = deque()

for i in range(n):
    m = int(s.readline())
    if i == 0 :
        stack.append(m)
    else:
        for i in range(len(stack),0,-1):
            if stack[len(stack)-1] <= m:
                stack.pop()   
            else:
                break 
        stack.append(m)
            

 

print(len(stack))