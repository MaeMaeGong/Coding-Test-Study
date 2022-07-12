import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    arr = list(int(input()) for _ in range(n))
    low = 0
    high = sum(arr)
    answer = 0
    while low <= high:
        mid = (low + high) // 2
        now = 0
        count = 0
        for i in arr:
            if now < i:
                now = mid
                count += 1
            now -= i
        
        if count > m or mid < max(arr):
            low = mid + 1
        else:
            high = mid - 1
            answer = mid
    print(answer)


if __name__ == "__main__" :
    main()