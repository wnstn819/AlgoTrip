from sys import stdin as s
import heapq

s= open('input.txt','rt')

N = int(s.readline())

arr = []

for _ in range(N):
    K = int(s.readline())
    heapq.heappush(arr, K)

sum =0
while len(arr) > 1:
    a = heapq.heappop(arr)
    b = heapq.heappop(arr)
    ans = a + b
    sum +=ans
    heapq.heappush(arr,ans)


print(sum)
