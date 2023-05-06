from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

arr = list(map(str.rstrip, s.readline()))


q = deque()
answer =0
temp = 1

for i in range(len(arr)):
    if arr[i] == "(":
        q.append(arr[i])
        temp *= 2
    elif arr[i] =="[":
        q.append(arr[i])
        temp *= 3
    elif arr[i] == ")":
        if not q or q[-1] == "[":
            answer =0
            break
        if arr[i-1] == "(":
            answer+=temp
        q.pop()
        temp //= 2
    else:
        if not q or q[-1] =="(":
            answer =0
            break
        if arr[i-1] == "[":
            answer+=temp
        q.pop()
        temp //= 3


if q:
    print(0)
else:
    print(answer)
