from sys import stdin as s
import sys
sys.setrecursionlimit(10**6)
s = open('input.txt','rt')


N = int(s.readline())

# def moo(num):
#     if num == 0:
#         return "moo"
#     s = moo(num-1)
    
#     if num == 1:
#         d = s+"o"
#         return s + d + s
#     elif num == 2:
#         d = "mooo"
#         return s + d +"o" + s
#     else:
#         d = moo(num-2)
#         temp = s.replace(d,"")
#         return s + temp + "o" + s


# print(moo(n)[n-1])



# def moo(num):
#     if num == 0:
#         return 3
#     else:
#         s = moo(num-1)
#         return s + num+3 + s
    


# if moo(n) % 2 == 0:
#     print('m')
# else :
#     print("o")


def moo(acc, cur, N):
    prev = (acc-cur)//2
    if N <= prev: return moo(prev, cur-1, N) # 왼쪽에 있을 때
    elif N > prev+cur: return moo(prev, cur-1, N-prev-cur) # 오른쪽
    else: return "o" if N-prev-1 else "m" # 중간

acc, n = 3, 0
while N > acc:
    n += 1
    acc = acc*2+n+3

print(moo(acc, n+3, N))