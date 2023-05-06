from sys import stdin as s
from collections import deque

s = open('input.txt')

N, K = list(map(int,s.readline().split()))

arr = list(map(str.rstrip,s.readline()))


a = deque()
a.append(int(arr[0]))

for i in range(1,N):
    while len(a) + N-i-1 >= N-K: # 스택 개수 + 남아있는 숫자 개수 >= 마지막에 필요한 개수
        if len(a)-1 >=0 and int(arr[i]) > a[len(a)-1]: # 스택의 크기가 0보다 크거나 같고, 현재 arr의 숫자가 스택의 마지막 숫자보다 클때 
            a.pop() # 스택의 마지막 숫자 제거
        else :
            if len(a) < N-K: # 스택의 숫자가 찾아야 하는 숫자의 개수보다 작으면 추가
                a.append(int(arr[i]))
            break

    if len(a) + N-i == N-K: # 스택의 개수 + 남은 개수가 구해야할 개수의 숫자와 일치할때 전부 입력해주기
        a.append(int(arr[i]))
    
    

for i in a:
    print(i,end='')
