from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

N, M = list(map(int, s.readline().split()))

arr = [*map(int, s.readline().split())]

result = 0


def binary(start,end):
    global result
    if start > end:
        result = end
        return 
    
    mid = (start+end)//2

    sum =0
    for i in arr:
        if i > mid:
            sum += i-mid

    
    if sum == M:
        result = mid
        
       
    elif sum > M:
        binary(mid+1,end)
    else:
        binary(start,mid-1)


binary(1,max(arr))

print(result)