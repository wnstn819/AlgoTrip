from sys import stdin as s
import math

A, B, C = list(map(int,s.readline().split()))


def dfa(number, n):
    if n == 1:
        return number % C
    temp = dfa(number,n//2)
    if n % 2 ==0:
        return temp*temp%C
    else:
        return temp*temp*number%C


print(dfa(A,B))