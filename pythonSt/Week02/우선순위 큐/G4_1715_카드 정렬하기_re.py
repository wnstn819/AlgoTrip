from sys import stdin as s
import heapq

s= open('input.txt','rt')

N = int(s.readline())

arr = []

for i in range(N):
    n = int(s.readline())
    heapq.heappush(arr,n)


sum = 0
while len(arr) > 1:
    a =heapq.heappop(arr)
    b = heapq.heappop(arr)
    sum += a+b
    heapq.heappush(arr,a+b)



print(sum)