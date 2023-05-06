from sys import stdin as s
import heapq

s = open('input.txt','rt')

n = int(s.readline())

arr = []

for i in range(n):
    for i in list(map(int,s.readline().split())):
        heapq.heappush(arr,-i)

    


print(-arr[n-1])