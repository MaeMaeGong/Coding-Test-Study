import heapq
from posixpath import split
import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    heapq.heapify(arr)
    for _ in range(m):
        temp1 = heapq.heappop(arr)
        temp2 = heapq.heappop(arr)
        heapq.heappush(arr, temp1 + temp2)
        heapq.heappush(arr, temp1 + temp2)
    print(sum(arr))

if __name__ == "__main__":
    main()