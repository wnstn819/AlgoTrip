from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

stack = deque()

for i in range(n):
    m = int(s.readline())
    if m == 0:
        if len(stack) > 0 :
            stack.pop()
    else:
        stack.append(m)


print(sum(stack))