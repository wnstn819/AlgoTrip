from sys import stdin as s

s = open('input.txt','rt')

n = s.readline().rstrip()

left = n[:len(n)//2]
right = n[len(n)//2:]

leftSum=0
rightSum=0

for i in left:
    leftSum += int(i)

for i in right:
    rightSum += int(i)


if leftSum == rightSum :
    print("LUCKY")
    print("dddd")






else:
    print("READY")
