from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

soldier_list = list(map(int, s.readline().split()))

soldier_list = soldier_list[::-1]
length = [0] * n

for k in range(n):
    length[k]= 1
    for i in range(0,k):
        if soldier_list[i] < soldier_list[k]:
            length[k] = max(length[k], length[i]+1)
        

print(n - max(length))