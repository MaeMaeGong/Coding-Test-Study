import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    arr = list(int(input()) for _ in range(m))
    left = 1
    right = max(arr)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        num = 0
        for i in arr:
            ch = i % mid
            if ch == 0:
                num += i // mid
            else:
                num += (i // mid) + 1
                
        if num > n:
            left = mid + 1
        else:
            right = mid - 1
            answer = mid

    print(answer)


if __name__ == "__main__":
    main()