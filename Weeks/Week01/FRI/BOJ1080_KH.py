import sys

input = sys.stdin.readline

def change(i, j):
    global a
    for x in range(i, i + 3):
        for y in range(j, j + 3):
            if a[x][y] == 0:
                a[x][y] = 1
            else:
                a[x][y] = 0

def main():
    global a
    n, m = map(int, input().split())
    a = [list(map(int, input().strip())) for _ in range(n)]
    b = [list(map(int, input().strip())) for _ in range(n)]
    cnt = 0
    for i in range(0, n - 2):
        for j in range(0, m - 2):
            if a[i][j] != b[i][j]:
                change(i, j)
                cnt += 1
    if a == b:
        print(cnt)
    else:
        print(-1)

if __name__ == "__main__":
    main()