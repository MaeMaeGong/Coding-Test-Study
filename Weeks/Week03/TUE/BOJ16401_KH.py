import sys
input = sys.stdin.readline

def main():
    m, n = map(int, input().split())
    arr = list(map(int, input().split()))
    left = 0
    right = max(arr)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        if mid == 0:
            print(0)
            return
        num = 0
        for i in arr:
            num += i // mid
        if num >= m:
            answer = max(answer, mid)
            left = mid + 1
        else:
            right = mid - 1
    print(answer)

if __name__ == "__main__":
    main()

# import copy
# import sys
# input = sys.stdin.readline

# def main():
#     m, n = map(int, input().split())
#     arr = list(map(int, input().split()))
#     left = 0
#     right = max(arr)
#     answer = 0
#     while left <= right:
#         mid = (left + right) // 2
#         num = 0
#         if n >= m:
#             for i in arr:
#                 if i >= mid:
#                     num += 1
#             if num < m:
#                 right = mid - 1
#             else:
#                 left = mid + 1
#                 answer = mid
#         else :
#             temp = copy.deepcopy(arr)
#             for i in range(m):
#                 temp.sort()
#                 if (temp[-1] - mid) >= 0:
#                     num += 1
#                     temp[-1] -= mid
#             if num < m:
#                 right = mid - 1
#             else:
#                 left = mid + 1
#                 answer = mid
#     print(answer)


# if __name__ == "__main__":
#     main()