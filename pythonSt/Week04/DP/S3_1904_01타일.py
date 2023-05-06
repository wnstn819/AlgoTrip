from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)

s = open('input.txt','rt')




n = int(s.readline())

dp = [0] * 1000001
dp[1] = 1
dp[2] = 2


for k in range(3,n+1):
    dp[k] = (dp[k-1]+dp[k-2])%15746

print(dp[n])

# def fibo(num):

#     if num == 1:
#         return  1
#     elif num == 2:
#         return 2
#     elif num == 3:
#         return 3
#     else:
#         return fibo(num-1)+fibo(num-2)



# print(fibo(n))


        