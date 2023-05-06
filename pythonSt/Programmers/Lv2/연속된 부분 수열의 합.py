# from collections import deque

# def solution(sequence, k):
#     answer = []
#     point = 0
#     point2 = 1
    

#     while True:
#         if point > len(sequence) or point2 > len(sequence):
#             break
#         result = sum(sequence[point:point2])
#         if result == k:
#             if answer:
#                 if answer[1]-answer[0] > point2-1 - point:
#                     answer = [point,point2-1]
                
#             else:
#                 answer = [point,point2-1]
#             point2 +=1
                
#         elif result > k :
#             point +=1
#         else:
#             point2 +=1
            
#     return answer

# print(solution([1,2,3,4,5],7))


def solution(sequence, k):
    partial_sum = 0
    right = 0
    result = []
    for left in range(len(sequence)):
        while right < len(sequence) and partial_sum < k:
            partial_sum += sequence[right]
            right += 1

        if partial_sum == k:
            if not result:
                result = [left, right - 1]
            else:
                result = result if result[1] - result[0] <= (right - 1) - left else [left, right - 1]

        partial_sum -= sequence[left]

    return result


print(solution([1,2,3,4,5],7))