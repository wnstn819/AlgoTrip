from sys import stdin as s
from collections import deque

n = int(s.readline())

stack = deque()

for i in range(n):
    h = int(s.readline())
    if not stack:
        stack.append(h)

    while stack and stack[-1] <= h:
        stack.pop()


    stack.append(h)


print(len(stack))