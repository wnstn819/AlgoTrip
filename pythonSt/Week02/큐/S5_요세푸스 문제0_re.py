from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n , m = list(map(int,s.readline().split()))

stack = deque([i for i in range(1,n+1)])



print("<", end="")
count = 1
while len(stack)>1:
    if count == m:
        print(stack.popleft(), end=", ")
        count = 1
    else:
        stack.append(stack.popleft())
        count +=1

print(stack[0], end=">")