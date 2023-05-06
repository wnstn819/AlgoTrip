from sys import stdin as s
from collections import deque

s = open('input.txt','rt')

# def solution(l, r):
#     global heights
#     if(l == r): return heights[l]
#     mid = (r + l) // 2
#     # 반반 쪼개서 가장 큰 부분을 가져온다.
#     area = max(solution(l, mid), solution(mid + 1, r))
#     lmid  = mid
#     rmid = mid + 1
#     height = min(heights[lmid], heights[rmid])

#     # 이전 구한 값과 중간 위치의 넓이를 비교해서 가장 큰 것은 가져 온다.
#     area = max(area, height * 2, heights[lmid], heights[rmid])
#     while (l < lmid or rmid < r):
#         if(rmid < r and ((lmid <= l) or (heights[lmid - 1] < heights[rmid + 1]))):
#             rmid += 1
#             height = min(height, heights[rmid])
#         else:
#             lmid -= 1
#             height = min(height, heights[lmid])
#         area = max(area, height * (rmid - lmid + 1))
#     return area

# while 1:
#     N, *heights = map(int, s.readline().split())
#     if  N == 0: break
#     print(solution(0, N - 1))

while True:
    rec = list(map(int, s.readline().split()))
    n = rec.pop(0)

    if n == 0 :
        break

    stack = deque()
    answer = 0

    for i in range(n):
        while len(stack) != 0 and rec[stack[-1]] > rec[i]:
            tmp = stack.pop()

            if len(stack) == 0:
                width = i
            else:
                width = i - stack[-1] -1
            answer = max(answer,width * rec[tmp])
        stack.append(i)

    
    while len(stack) != 0:
        tmp = stack.pop()

        if len(stack) == 0:
            width = n
        else:
            width = n - stack[-1] -1
        answer = max(answer, width * rec[tmp])
        
    print(answer)
