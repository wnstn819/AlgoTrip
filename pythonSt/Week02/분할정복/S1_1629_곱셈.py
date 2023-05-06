from sys import stdin as s
import math
s = open('input.txt','rt')

A, B, C = list(map(int,s.readline().split()))


def dfs(a,b):
    if b == 1:
        return a % C
    
    temp = dfs(a,b//2)

    if b % 2 == 0:
        return temp * temp % C
    else:
        return temp * temp * a % C

print(dfs(A,B))

