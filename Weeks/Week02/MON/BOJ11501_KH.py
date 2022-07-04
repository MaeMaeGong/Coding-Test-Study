import heapq
import sys
input = sys.stdin.readline

def main():
    t = int(input())
    result = []
    for j in range(t):
        n = int(input())
        sum_ = 0
        arr = list(map(int, input().split()))
        m = arr[-1]
        for j in range(n-2, -1, -1):  
            if m > arr[j]:
                sum_ += m - arr[j]
            else:
                m = arr[j]
        result.append(sum_)
    for i in result:
        print(i)
                


if __name__ == "__main__":
    main()