from sys import stdin as s
import math
a, b ,v = map(int, s.readline().split())

result = math.ceil((v-a)/(a-b)) + 1

print(result)
