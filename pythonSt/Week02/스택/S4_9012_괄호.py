from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())



for i in range(n):
    stack = deque()
    str = list(s.readline().rstrip())
    text = "YES"
    for j in str:
        if j == "(":
            stack.append("(")
        else:
            if len(stack) > 0:
                stack.pop()
            else:
                text = "NO"
                break

        
    if len(stack) > 0 :
        text = "NO"
    
    print(text)
    