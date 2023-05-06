from sys import stdin as s
from queue import PriorityQueue

s = open('input.txt','rt')

N = list(map(int,s.readline().split()))

arr = list(map(int, s.readlines()))

q = PriorityQueue()

for i in arr:
    if q.empty() and i == 0:
        print("0")
    elif i ==0:
        print(q.get())
    else: 
        q.put(i,i)





