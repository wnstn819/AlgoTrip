from sys import stdin as s

s = open('input.txt','rt')

M, N, L = list(map(int,s.readline().split()))

arr = list(map(int, s.readline().split()))

arr.sort()

result =0 


def binary(start,end,x,y):
    if start > end:
        return False
    
    mid = (start+end)//2

    if arr[mid] < x:
        return binary(mid+1,end,x,y)
    elif arr[mid] > y:
        return binary(start,mid-1,x,y)
    else:
        return True



for _ in range(N):
    x , y = list(map(int,s.readline().split()))
    
    minX = x - (L - y)
    maxX = x + (L - y)

    if y <= L and binary(0,len(arr)-1,minX,maxX):
        result +=1


print(result)



