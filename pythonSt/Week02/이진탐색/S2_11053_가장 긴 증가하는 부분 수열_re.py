from sys import stdin as s
import sys
s = open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

cal = [0] * (n)

for i in range(n-1,-1,-1):
    maxCal = 0
    for j in range(i,n):
        if arr[i] < arr[j]:
            maxCal = max(cal[j],maxCal)
        
    cal[i] = maxCal + 1

print(max(cal))