from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')

N, M = list(map(int, s.readline().split()))

arr = [*map(int, s.readline().split())]

result = 0

def cutting(cutter):
    sum = 0
    for tree in arr:
        rest = tree - cutter
        if rest > 0:
            sum += rest
    return sum

def binary(start, end , num):
    if start > end:
        return end 
    mid = (start+end)//2
    ans = cutting(mid)
    if ans == num :
        return mid

    elif ans > num:
        return binary(mid+1,end,num)
        
    else :
        return binary(start,mid-1,num)
        
    


print(binary(1, max(arr), M))



