from sys import stdin as s
from collections import deque

s = open('input.txt', 'rt')

n = int(s.readline())

stack = deque()

for i in range(n):
    T = list(map(str,s.readline().split()))
    
    if T[0] == "push":
        stack.append(T[1])
    elif T[0] == "top":
        if len(stack) !=0:
            print(stack[len(stack)-1])
        else : 
            print("-1")
    elif T[0] == "size":
            print(len(stack))
    elif T[0] == "pop":
        if len(stack) !=0:
            print(stack[len(stack)-1])
            stack.pop()
        else : 
            print("-1")
    elif T[0] == "empty":
        if len(stack) == 0:
            print("1")
        else :
            print("0")
        