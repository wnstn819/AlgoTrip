from sys import stdin as s
import math

s = open('input.txt','rt')

a, b = s.readline().split()

# asum =0
# bsum =0
# for i in range(2,-1,-1):
#     asum += math.pow(10,i)*int(a[i])
#     bsum += math.pow(10,i)*int(b[i])

#print(int(asum) if asum > bsum else  int(bsum) )
#print(int(max(asum,bsum)))


a = a[::-1]
b = b[::-1]


print(max(a,b))



