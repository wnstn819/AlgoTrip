from sys import stdin as s

s = open('input.txt','rt')

a = int(s.readline())


def rec(n):
    if n > 0 :
        return n * rec(n-1)
    else:
        return 1
    

print(int(rec(a)))