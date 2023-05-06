from typing import MutableSequence

s = open('input.txt','rt')

n = int(s.readline())
a = list(map(int,s.readlines()))

def sort3(a:MutableSequence, idx1:int, idx2: int, idx3:int):
    if a[idx2] < a[idx1]: a[idx2], a[idx1] = a[idx1], a[idx2]
    if a[idx3] < a[idx2]: a[idx3], a[idx2] = a[idx2], a[idx3]
    if a[idx2] < a[idx1]: a[idx2], a[idx1] = a[idx1], a[idx2]
    return idx2
def quicksort(a: MutableSequence, left : int, right: int):
    pl, pr = left, right
    m = sort3(a,pl,(pl+pr)//2,pr)
    pivot = a[m]
    a[m], a[pr-1] = a[pr-1],a[m]
    pl+=1
    pr-=2
    while pl<=pr:
        while a[pl] < pivot: pl+=1
        while a[pr] > pivot : pr-=1
        if pl <=pr:
            a[pl],a[pr] = a[pr], a[pl]
            pl+=1
            pr-=1
    if left < pr: quicksort(a,left,pr)
    if pl < right: quicksort(a,pl,right)


quicksort(a,0,len(a)-1)

for i in a:
    print(i)