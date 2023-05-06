from sys import stdin as s
import heapq

s = open("input.txt",'rt')

N = int(s.readline())

arr=[]

test = []

result = 0

for i in range(N):
    h, o = map(int,s.readline().split())
    ma = max(h,o)
    mi = min(h,o)
    heapq.heappush(arr,(mi,ma))

K = int(s.readline())

while arr:
    h, o = heapq.heappop(arr)
    if abs(h-o) > K:
        continue 
    else:
        heapq.heappush(test,h)
    

    while len(test) != 0:
        tmp = test[0]
        if o-tmp<=K:
            break
        else:
            heapq.heappop(test)


    result = max(result,len(test))

print(result)

