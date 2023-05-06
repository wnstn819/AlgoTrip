from sys import stdin as s
import sys
s = open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

cal = [0] * (n)

for i in range(n-1,-1,-1):
    a = arr[i]
    temp =0
    for j in range(i,n):
        if a < arr[j]:
            temp = max(temp,cal[j])
            cal[i] = temp + 1
            
            


print(max(cal)+1)