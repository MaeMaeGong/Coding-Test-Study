import copy
import sys
input = sys.stdin.readline

def change(i):
    global n, a, b
    if i == 0:
        for j in (i, i+1):
            if a[j] == 0:
                a[j] = 1
            else:
                a[j] = 0
    elif i == n - 1:
        for j in (i - 1, i):
            if a[j] == 0:
                a[j] = 1
            else:
                a[j] = 0
    else:
        for j in (i - 1, i, i + 1):
            if a[j] == 0:
                a[j] = 1
            else:
                a[j] = 0

        
def main():
    global n, a, b
    n = int(input())
    a = list(map(int, input().rstrip()))
    b = list(map(int, input().rstrip()))
    temp1 = copy.deepcopy(a)
    temp2 = copy.deepcopy(a)

    flag = False
    answer = sys.maxsize
    for k in range(2):
        cnt = 0
        if k == 0:
            a = temp1 
        else:
            a = temp2

        for t in range(n):
            if t == 0 and k == 0 and a != b:
                cnt += 1
                change(t)
            elif t >= 1 and a[t - 1] != b[t - 1]:
                cnt += 1
                change(t)

        if a == b:
            answer = min(answer, cnt)
            flag = True

    if flag:
        print(answer)
    else:
        print(-1)


if __name__ == "__main__":
    main()