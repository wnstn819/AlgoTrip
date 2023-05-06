from sys import stdin as s
s = open('input.txt','rt')

n = int(s.readline())
arr = list(map(int,s.readline().split()))

arr.sort()
arr.reverse()

for i in range(1,n):
    arr[0] += arr[i]/2


print(arr[0])