from sys import stdin as s
from queue import PriorityQueue

N = list(map(int,s.readline().split()))

arr = list(map(int, s.readlines()))

q = PriorityQueue()

for i in arr:
    if q.empty() and i == 0:
        print("0")
    elif i ==0:
        print(q.get()*-1)
    else: 
        q.put(i*-1,i)





