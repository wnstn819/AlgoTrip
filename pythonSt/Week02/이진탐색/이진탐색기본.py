from sys import stdin as s

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

arr = list(map(int,s.readline().split()))

def binary_search(array, target,start,end):
    if start > end:
        return None
    mid = (start + end) //2

    if array[mid] == target:
        return mid
    elif array[mid] >target:
        return binary_search(array,target,start,mid-1)

    else :
        return binary_search(array,target,mid+1,end)
    

result = binary_search(arr,M,0,N-1)
if result == "None":
    print("존재하지 않습니다.")
else:
    print(result + 1)


