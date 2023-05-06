from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')

n = int(s.readline())
a = list(map(int,s.readlines()))

def quick(a):
    if len(a) <= 1:
        return a
    else:
        pivot = a[0]
        left = []
        right = []
        for i in a[1:]:
            if i < pivot:
                left.append(i)
            elif i > pivot:
                right.append(i)

        return quick(left) + [pivot] + quick(right)
    

sorted_list = quick(a)

for i in sorted_list:
    print(i)
        
