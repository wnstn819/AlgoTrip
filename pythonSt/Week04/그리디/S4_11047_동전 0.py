from sys import stdin as s
s = open('input.txt','rt')

N, K = list(map(int,s.readline().split()))

arr = [int(s.readline()) for i in range(N)]
arr.reverse()


count =0
i = 0
while K !=0:
    if K//arr[i] > 0:
        count += K//arr[i]
        K = K%arr[i]
    i += 1

print(count)








