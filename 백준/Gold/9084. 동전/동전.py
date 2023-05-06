from sys import stdin as s

T = int(s.readline())

for _ in range(T):
    n = int(s.readline())
    arr = list(map(int,s.readline().split()))
    money = int(s.readline())
    dp = [0 for i in range(money+1)]
    dp[0] = 1
    for i in arr: # 동전
        for o in range(1,money+1): # 1부터 금액까지
            if o >= i:
                dp[o] = dp[o] + dp[o-i]
    print(dp[money])