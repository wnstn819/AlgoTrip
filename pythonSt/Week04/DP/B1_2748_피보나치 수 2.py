from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [0] * (n+1)

def fibo(N):
    if N ==1 :
        arr[N] = 1
    elif N == 2:
        arr[N] = 1
    else:
        arr[N] = arr[N-1] + arr[N-2]





for i in range(1,n+1):
    fibo(i)


print(arr[n])


n = 1 1
n = 2 2
n = 3 