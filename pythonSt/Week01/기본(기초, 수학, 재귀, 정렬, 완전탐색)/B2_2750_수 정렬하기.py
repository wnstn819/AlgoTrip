from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)
s= open('input.txt','rt')

n = int(s.readline())
a = list(map(int, s.readlines()))


def quick(a,start,end):
    if start >= end : return

    pl = start + 1
    pr = end
    pivot = start

    while pl <= pr :
        while  pl <= end and a[pl] <= a[pivot] : pl +=1
        while  pr > start and a[pr] >= a[pivot] : pr -=1
        if pl > pr:
            a[pr] , a[pivot] = a[pivot], a[pr]
            
        else:
            a[pl], a[pr] = a[pr] , a[pl]

    quick(a,start,pr -1)
    quick(a,pr+1, end)


quick(a,0,len(a)-1)

for i in a:
    print(i)