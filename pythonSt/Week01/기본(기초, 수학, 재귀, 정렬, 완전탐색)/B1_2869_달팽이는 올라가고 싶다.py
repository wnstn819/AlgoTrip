from sys import stdin as s
import math

s = open('input.txt','rt')

a, b ,v = map(int, s.readline().split())

result = math.ceil((v-a)/(a-b)) + 1 # 5 1 6 의 경우 (v-a)/(a-b) 하면 0.25가 나오는데 이럴 경우 하루 올라간 거기 때문에 올림해줘야됨

print(result)
