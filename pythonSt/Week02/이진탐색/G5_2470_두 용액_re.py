from sys import stdin as s
import sys
s = open('input.txt','rt')

n = int(s.readline())

arr = list(map(int,s.readline().split()))

arr.sort()

pl = 0
pr = len(arr)-1
result = sys.maxsize
resultL= 0
resultR=0
while pl < pr:
    nearZero = arr[pl] + arr[pr]
    if nearZero == 0:
        resultL = pl
        resultR = pr
        break

    if abs(nearZero) < result :
        resultL = pl
        resultR = pr
        result = abs(nearZero)

    if nearZero > 0 :
        pr -=1
    else:
        pl +=1



print(arr[resultL], arr[resultR])