import sys
input = sys.stdin.readline
import heapq

def main():
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    classroom = []
    arr.sort(key=lambda x:x[0])
    heapq.heappush(classroom, arr[0][1])
    for i in range(1, len(arr)):
        if arr[i][0] < classroom[0]:
            heapq.heappush(classroom, arr[i][1])
        else:
            heapq.heappop(classroom)
            heapq.heappush(classroom, arr[i][1])
    print(len(classroom))

if __name__ == "__main__":
    main()