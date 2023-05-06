from sys import stdin as s
import math

n = int(s.readline())

a = list(map(int, s.readline().split()))


temp = [True] * int(max(a)+1)

def test(n):
    for i in range(2, int(n**0.5) + 1):
            if temp[i]== True:
                for j in range(i+i, n+1, i):
                     
                     temp[j] = False
            


test(max(a))
count =0
for i in a:
    if i != 1 and temp[i]:
        count += 1


print(count)