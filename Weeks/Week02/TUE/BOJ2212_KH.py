import sys
input = sys.stdin.readline

def main():
    n = int(input())
    k = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    if k >= n:
        print(0)
        return
    costs = []
    for i in range(n - 1):
        costs.append(arr[i + 1] - arr[i])
    costs.sort()
    print(sum(costs[:n-k]))

if __name__ == "__main__":
    main()
