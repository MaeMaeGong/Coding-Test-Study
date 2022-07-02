import sys
input = sys.stdin.readline

def main():
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    arr.sort(key=lambda x:x[1], reverse=True)
    end_time = arr[0][1] - arr[0][0]
    for i in range(1, n):
        if arr[i][1] > end_time:
            arr[i][1] = end_time
        end_time = arr[i][1] - arr[i][0]
            
    if end_time < 0:
        print(-1)
    else:
        print(end_time)

if __name__ == "__main__":
    main()