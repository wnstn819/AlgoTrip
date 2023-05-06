# from typing import MutableSequence

# def qsort(a: MutableSequence, left: int, right: int) -> None:

#     pl = left
#     pr = right
#     x = a[(left + right)//2]
   
#     while pl <= pr:
#         while a[pl] < x : pl += 1
#         while a[pr] > x : pr -= 1
#         if pl <= pr:
#             a[pl], a[pr] = a[pr], a[pl]
#             pl += 1
#             pr -= 1

        
#     if left < pr : qsort(a,left,pr)
#     if pl < right: qsort(a, pl,right)


# def quick_sort(a: MutableSequence) -> None:
#     qsort(a,0, len(a)-1)


# if __name__ == '__main__':
#     print('퀵 정렬을 수행합니다.')
#     num = int(input('원소 수를 입력하세요.: '))
#     x = [None] * num

#     for i in range(num):
#         x[i] = int(input(f'x[{i}]: '))

#     quick_sort(x)

#     print("오름차순으로 정렬했습니다.")
#     for i in range(num):
#         print(f'x[{i}] = {x[i]}')

# a = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
a = [9,7,8]


def quick(a,start,end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while left <= right:
        while left <= end and a[left] <= a[pivot]:
            left +=1
        while right > start and a[right] >= a[pivot]:
            right -= 1

        if left > right :
            a[right], a[pivot] = a[pivot], a[right]
        else:
            a[left], a[right] = a[right], a[left]
        
    
    quick(a,start, right-1)
    quick(a,right +1, end)


if __name__ == '__main__':
    # 피벗 설정

    quick(a,0,len(a)-1)
    print(a)