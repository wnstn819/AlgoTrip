from sys import stdin as s
from collections import deque

n, k = list(map(int, s.readline().split()))
numbers = list(map(str.rstrip,s.readline()))

stack = deque()

for i in range(n):
    while stack and stack[-1] < int(numbers[i]) and k > 0:
        stack.pop()
        k -= 1
    stack.append(int(numbers[i]))


while k > 0:
    stack.pop()
    k -= 1

for i in stack:
    print(i, end='')

    

