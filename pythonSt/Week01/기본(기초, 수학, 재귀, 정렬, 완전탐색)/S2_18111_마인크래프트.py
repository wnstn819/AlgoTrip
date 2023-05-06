from sys import stdin as s

s = open('input.txt','rt')

N, M ,B = list(map(int,s.readline().split()))

array = [list(map(int,s.readline().split())) for _ in range(N)]

listMax = max(map(max,array))
listMin = min(map(min,array))

height_cnt = [0 for _ in range(listMax+1)]

for i in array:
    for j in i:
        height_cnt[j] += 1

result = int(1e9)
resultH = 0

for k in range(listMin,listMax+1):
    ans = 0
    block = B
   
    for i in range(listMax+1):
        if i < k:
            ans = ans+ (k-i)*height_cnt[i]
            block -= height_cnt[i] * abs(k - i)
        elif i > k:
            ans = ans + (i-k)*height_cnt[i]*2
            block += height_cnt[i] * abs(k-i)

            
    if block < 0 :
        continue
    if result >= ans and  resultH <= k:
        result = ans
        resultH = k

print(result, resultH)
    


# 처음 짠 코드 - 시간 초과

# listMax = max(map(max,array))
# listMin = min(map(min,array))

# height_cnt = [0 for _ in range(listMax+1)]

# result = int(1e9)
# resultH = 0

# for k in range(listMin,listMax+1):
#     ans = 0
#     block = B
   
#     for i in range(N):
#         for j in range(M):
#             if array[i][j] > k :
#                 ans +=(array[i][j] - k) * 2
#                 block += 1
#             else:
#                 ans +=abs(array[i][j] - k) * 1
#                 block -= 1
            
#     if block < 0 :
#         continue
#     if result > ans:
#         result = ans
#         resultH = k