from sys import stdin as s
import heapq

leftHeap = []
rightHeap = []

n = int(s.readline())

arr = list(map(int,s.readlines()))


for i in arr:
    if len(leftHeap) == len(rightHeap):
        heapq.heappush(leftHeap,-i)
    else:
        heapq.heappush(rightHeap,i)
        

    if leftHeap and rightHeap and -leftHeap[0] > rightHeap[0]:
        left = -heapq.heappop(leftHeap)
        right = heapq.heappop(rightHeap)
        heapq.heappush(leftHeap,-right)
        heapq.heappush(rightHeap,left)

    print(-leftHeap[0])


    