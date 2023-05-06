from sys import stdin as s
s = open('input.txt','rt')
arr = [list(map(int,s.readline().split())) for _ in range(7)]


def solution(targets):
    answer = 0
    targets.sort(key= lambda x : x[1])
    targetin = 0
    for target in targets:
        if targetin <= target[0]:
            answer +=1
            print(target)
            targetin = target[1]
    return answer


print(solution(arr))