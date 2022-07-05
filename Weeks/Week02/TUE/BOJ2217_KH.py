import sys
input = sys.stdin.readline

def main():
    n = int(input())
    arr = [int(input()) for i in range(n)]
    arr.sort()
    result = []
    for i in range(n):
        result.append((n-i) * arr[i])
    print(max(result))

if __name__ == "__main__":
    main()