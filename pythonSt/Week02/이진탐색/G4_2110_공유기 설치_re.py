from sys import stdin as s

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

arr = list(map(int, s.readlines()))

arr.sort()

result = 0


def binary(start,end):
    global result
    if start > end:
        result = end
        return
    
    mid = (start + end)//2

    cnt = 1
    place = arr[0]
    for i in range(1,N):
        if arr[i] - place >= mid:
            place = arr[i]
            cnt +=1

    if cnt == M:
        result = max(result,mid)
    if cnt >= M :
        binary(mid+1,end)
    else:
        binary(start,mid-1)


binary(1, arr[len(arr)-1]-arr[0])

print(result)
        


