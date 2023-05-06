from sys import stdin as s
import heapq

s = open('input.txt','rt')

N = list(map(int,s.readline().split()))

arr = list(map(int, s.readlines()))

maxheap = []

for i in arr:
    if i ==0 :
        if not maxheap:
            print("0")
        else:
            print(-heapq.heappop(maxheap))
    else:
        heapq.heappush(maxheap,-i)
    
    
