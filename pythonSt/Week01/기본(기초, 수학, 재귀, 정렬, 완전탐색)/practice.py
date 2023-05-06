from sys import stdin as s
import math

s = open('input.txt','rt')

arr = list(map(int,s.readlines()))


print(arr)
arr.sort()

def dfs(li,start):
    if len(li) == 7:
        if sum(li) == 100:
            for i in li:
                print(i)
            exit()
        return

    for i in range(start,len(arr)):
        li.append(arr[i])
        dfs(li,i+1)
        li.pop()


dfs([],0)



# def test(num):
#     if num == 1:
#         return False
#     for i in range(2,int(num ** 0.5)+1):
#         if (num% i)== 0:
#             return False
#     return True

# for i in range(n):
#     number = int(s.readline())
    
#     a = number//2
#     b = number//2

#     while a >0 :
#         if test(a) and test(b):
#             print(a, b)
#             break
        
#         else:
#             a -=1
#             b +=1


            




#소수 찾기
# arr = list(map(int,s.readline().split()))

# visited = [True] * int(max(arr)+1)

# def test(num):

#     for i in range(2,int(num ** 0.5)+1):
#         if visited[i] == True:
#             for j in range(i+i, num+1, i):
#                 visited[j] = False

# test(max(arr))

# count =0
# for i in arr:
#     if i != 1 and visited[i]:
#         count +=1

# print(count)




# 달팽이
# A, B, V = map(int,s.readline().split())

# result =  math.ceil(((V-A)/(A-B)))

# print(result + 1 )








