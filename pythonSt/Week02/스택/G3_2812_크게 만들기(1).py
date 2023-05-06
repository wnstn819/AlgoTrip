from sys import stdin as s

s = open('input.txt','rt')

n, k = list(map(int, s.readline().split()))
numbers = list(map(str.rstrip,s.readline()))
stack = []
for number in numbers:
    while stack and stack[-1] < number and k > 0:
        stack.pop()
        k -= 1
    stack.append(number)
if k > 0:
    print(''.join(stack[:-k]))
else:
    print(''.join(stack)) 