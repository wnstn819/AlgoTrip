from sys import stdin as s
s= open('input.txt','rt')

s = list(map(str,s.readline().split("-")))
sum = 0

for i in range(len(s)):
    num = s[i].split("+")
    for j in num:
        if i == 0 :
            sum += int(j)

        else:
            sum -= int(j)        


print(sum)