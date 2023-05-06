from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

a = list(map(str.rstrip, s.readlines()))

word = list(set(a))

word.sort()
word.sort(key=len)

for i in word:
    print(i)
# a=[[] for _ in range(51)]  

# for i in range(n):
#     text = s.readline().rstrip()
#     if text not in a[len(text)]:
#         a[len(text)].append(text)
#         a[len(text)].sort()



# for i in range(51):
#     for j in a[i]:
#         print(j)




