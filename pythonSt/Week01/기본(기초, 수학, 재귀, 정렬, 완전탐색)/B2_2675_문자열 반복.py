from sys import stdin as s


s = open('input.txt','rt')

a = int(s.readline())

# for i in range(0,a):
#     b = list(map(str,s.readline().rstrip()))
#     for j in b[2:]:

#         for k in range(0,int(b[0])):
#             print(j, end="")

#     print()


for _ in range(a):
    n, t = s.readline().split()
    for i in t:
        print(i*int(n),end="")
    print()