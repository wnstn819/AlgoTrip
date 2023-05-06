from sys import stdin as s

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

arr = list(map(int, s.readlines()))

arr.sort()


result = 0
def binary(start, end, cnt):
    global result
    if start > end:
        return
    mid = (start+end)//2

    value = arr[0]
    count = 1

    for i in range(1,N):
        if arr[i] >= value + mid:
            value = arr[i]
            count +=1
        
    if count >= cnt:
        start = mid +1
        result = mid
        binary(start,end,M)

    else :
        end = mid -1
        binary(start,end,M)


    

binary(arr[1] - arr[0], arr[-1] - arr[0], M)
print(result)
