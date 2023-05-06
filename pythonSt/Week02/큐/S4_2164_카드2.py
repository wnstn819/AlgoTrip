from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

stack = deque()

for i in range(1,n+1):
    stack.append(i)


while len(stack) > 1:
    stack.popleft()
    stack.append(stack.popleft())

print(stack[0])


