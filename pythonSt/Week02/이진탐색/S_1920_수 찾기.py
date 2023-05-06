from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

m = int(s.readline())

arr2 = list(map(int,s.readline().split()))


arr.sort()

def binary_search(l,N,start,end):
    if start > end:
        return 0
    mid = (start + end)//2
    
    if l == N[mid]:
        return 1

    elif l < N[mid]:
       return binary_search(l,N,start,mid-1)
    else : 
       return binary_search(l,N,mid+1,end)





for i in arr2:
    start = 0
    end = len(arr) - 1
    print(binary_search(i,arr,start,end))

