from sys import stdin as s

s = open('input.txt','rt')

K, N = map(int,s.readline().split())

arr = list(map(int,s.readlines()))

cnt = 0

result =0
def binary(start, end, N):
    global result
    mid = (start+ end)//2
    if start > end:
        result = mid
        return end
    cnt = 0
    for i in arr:
        c = i//mid
        cnt += c


    if cnt >= N: # 갯수가 같거나 많으면 더 긴 길이 찾아야됨
        result = max(result,mid)
        binary(mid+1, end,N)
    else:   # 갯수가 적으면 길이를 줄여야됨
        binary(start,mid-1,N)


binary(1,max(arr),N)
print(result)
