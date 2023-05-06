from sys import stdin as s

a = int(s.readline())

count =0
for i in range(1,a+1):
    if i < 100 :
        count += 1
    else:
        temp = list(map(int, str(i)))
        text= temp[0] - temp[1]
        for j in range(1,len(temp)-1):
            if temp[j] + (text*-1) == temp[j+1]:
                count += 1
            
        

print(count)