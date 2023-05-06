from sys import stdin as s

s = open('input.txt','rt')

N, M = list(map(int,s.readline().split()))

arr = [0] * (N+1)

for i in range(1,N+1):
    arr[i] = i


def union(a,b): # 결합
    a = find(a)
    b = find(b)

    if a < b:
        arr[b] = a
    else:
        arr[a] = b



def find(b): # 찾기

    if arr[b] != b:
        arr[b] = find(arr[b])

    return arr[b]

data =[]
for i in range(M):
    u ,v = list(map(int,s.readline().split()))
    data.append((u,v))


data.sort(key= lambda x: x[1])

for _ in range(2):
    for i,j in data:
        union(i,j)


print(arr)
tt=set(arr)
print(len(tt)-1)