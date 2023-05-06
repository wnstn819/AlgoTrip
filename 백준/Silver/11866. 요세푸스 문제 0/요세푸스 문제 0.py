from sys import stdin as s
from collections import deque
n , m = list(map(int,s.readline().split()))

stack = deque([i for i in range(1,n+1)])



print("<", end="")
count =1
while stack:
    if count == m:
        if len(stack) == 1:
            print(stack.popleft(), end=">")
        else :
            print(stack.popleft(), end=", ")
        count = 1
        continue
    
    stack.append(stack.popleft())
    count +=1




