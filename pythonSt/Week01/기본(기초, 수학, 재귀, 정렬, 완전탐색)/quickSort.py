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


# global a
# a = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

# def quick(a,start,end):
#     if start >= end : return

#     pl = start + 1
#     pr = end
#     pivot = start

#     while pl <= pr :
#         while  pl <= end and a[pl] <= a[pivot] : pl +=1
#         while  pr > start and a[pr] >= a[pivot] : pr -=1
#         if pl > pr:
#             a[pr] , a[pivot] = a[pivot], a[pr]
            
#         else:
#             a[pl], a[pr] = a[pr] , a[pl]

#     quick(a,start,pr -1)
#     quick(a,pr+1, end)
    

global a
a = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick(a):
    if len(a) <=1:
        return a
    pivot = a[0]
    tail = a[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return quick(left_side) + [pivot] + quick(right_side)


if __name__ == '__main__':
    # 피벗 설정

    print(quick(a))
   