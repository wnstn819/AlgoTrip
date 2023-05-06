from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

li = [0] * 10001

for i in range(n):
    num = int(s.readline())
    li[num] += 1



for i in range(10001):
    for j in range(li[i]):
        print(i)

