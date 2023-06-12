import heapq
def solution(scoville, K):
    answer = 0
    heap = []
    for i in scoville:
        heapq.heappush(heap,i)
    
    while(heap[0] < K and len(heap) >= 2):
        answer += 1
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        heapq.heappush(heap, a+(b*2))
    if(heap[0] < K):
        answer = -1
    return answer