from sys import stdin as s
import math
s = open('input.txt','rt')

A, B, C = list(map(int,s.readline().split()))

def dfa(number, n):
    if n == 1:
        return number
    elif n == 2 :
        return number * number % C

    else:
        temp = dfa(number,n//2)
        if n % 2 == 0:
            return temp * temp % C
        else :
            return temp * temp * number % C


print(dfa(A,B))

#시간 초과
# def dfa(number, n):
#     if n == 1:
#         return number % C


#     if n % 2 == 0:
#         return dfa(number,n//2) * dfa(number,n//2) % C
#     else :
#         return dfa(number,n//2) * dfa(number,n//2) * number % C


# print(dfa(A,B))


#성공
# def dfa(number, n):
#     if n == 1:
#         return number % C
#     temp = dfa(number,n//2)
#     if n % 2 ==0:
#         return temp*temp%C
#     else:
#         return temp*temp*number%C


# print(dfa(A,B))