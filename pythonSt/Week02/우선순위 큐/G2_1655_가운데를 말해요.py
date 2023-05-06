from sys import stdin as s
import heapq



leftHeap = []
rightHeap = []

s= open('input.txt','rt')


n = int(s.readline())

arr = list(map(int,s.readlines()))


for i in range(n):
    
    if len(leftHeap) > len(rightHeap):
        heapq.heappush(rightHeap,arr[i])
    else :
        heapq.heappush(leftHeap,-arr[i])

    if len(leftHeap) != 0 and len(rightHeap) != 0 and -leftHeap[0] > rightHeap[0] :
        left = -heapq.heappop(leftHeap)
        right = heapq.heappop(rightHeap)
        heapq.heappush(leftHeap,-right)
        heapq.heappush(rightHeap,left)

    print(-leftHeap[0])
            






        #### 처음 삽질한 방식 mid를 두고 앞뒤 조정   
        # if mid > arr[i]:
        #     mid ,arr[i] = arr[i], mid

        # if len(leftHeap) == len(rightHeap):
        #     if arr[i] > mid:
        #         heapq.heappush(rightHeap,arr[i])
        #     elif arr[i] < mid :
        #         heapq.heappush(leftHeap,-arr[i])
        #     else :
        #         heapq.heappush(leftHeap,-arr[i])

        # elif len(leftHeap) > len(rightHeap):
        #     if arr[i] > mid:
        #         heapq.heappush(rightHeap,arr[i])
        #     elif arr[i] < mid:
        #         heapq.heappush(temp,-heapq.heappop(leftHeap))
        #         heapq.heappush(temp,mid)
        #         heapq.heappush(temp,arr[i])
                
        #         heapq.heappush(leftHeap,-heapq.heappop(temp))
        #         mid = heapq.heappop(temp)
        #         heapq.heappush(rightHeap,heapq.heappop(temp))
        #     else :
        #         heapq.heappush(rightHeap,arr[i] )
          

        # else :
        #     if arr[i] < mid:
        #         heapq.heappush(leftHeap,-arr[i])
        #     elif arr[i] > mid:
        #         heapq.heappush(temp,heapq.heappop(rightHeap))
        #         heapq.heappush(temp,mid)
        #         heapq.heappush(temp,arr[i])
                
        #         heapq.heappush(leftHeap,-heapq.heappop(temp))
        #         mid = heapq.heappop(temp)
        #         heapq.heappush(rightHeap,heapq.heappop(temp))
        #     else :
        #         heapq.heappush(leftHeap,-arr[i])


            