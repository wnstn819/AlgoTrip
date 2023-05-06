from sys import stdin as s

s = open('input.txt','rt')

n = int(s.readline())

arr = [0] + list(map(int,s.readline().split()))
arr2 = [0] * (1001)

# for i in range(1,n+1):
#     temp = n//i
#     temp2 = n%i
#     arr2[i] = (temp*arr[i]) + arr[temp2]

# print(max(arr2))


for i in range(1,n+1):
    for j in range(1, i+1):

        arr2[i] = max(arr2[i],arr2[i-j] + arr[j])

print(arr2[n])
print(arr2) 