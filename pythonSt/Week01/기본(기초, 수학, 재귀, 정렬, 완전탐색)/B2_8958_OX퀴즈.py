n = int(input())
for i in range(0,n):
    a = list(input())
    sum = 0
    plus = 1
    for j in a:
        if j == 'O':
            sum += plus
            plus +=1
        else:
            plus = 1

    print(sum)