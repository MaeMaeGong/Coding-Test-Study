import sys
input = sys.stdin.readline

def main():
    n = int(input())
    arr = list(input().rstrip())
    answer = 500001
    cnt = 0
    flag = False
    for i in range(n):
        if arr[i] == "B":
            flag = True
        if arr[i] == "R" and flag:
            cnt += 1
    answer = min(answer, cnt)
    cnt = 0
    flag = False
    for i in range(n - 1, -1, -1):
        if arr[i] == "B":
            flag = True
        if arr[i] == "R" and flag:
            cnt += 1
    answer = min(answer, cnt)
    cnt = 0
    flag = False
    for i in range(n):
        if arr[i] == "R":
            flag = True
        if arr[i] == "B" and flag:
            cnt += 1
    answer = min(answer, cnt)
    cnt = 0
    flag = False
    for i in range(n - 1, -1, -1):
        if arr[i] == "R":
            flag = True
        if arr[i] == "B" and flag:
            cnt += 1
    answer = min(answer, cnt)

    print(answer)


if __name__ == "__main__":
    main()