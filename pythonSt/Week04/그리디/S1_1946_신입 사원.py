from sys import stdin as s

s = open('input.txt','rt')

T = int(s.readline())

for _ in range(T):
    N = int(s.readline())
    arr = [list(map(int,s.readline().split())) for _ in range(N)]
    arr.sort()
    number =arr[0][1];
    count = 1
    for i,j in arr[1:]:
        if j > number :
            continue
        elif j < number:
            count += 1
            number = j


    print(count)


    

