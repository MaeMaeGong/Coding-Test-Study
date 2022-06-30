import sys
input = sys.stdin.readline

def main():
    n = int(input())
    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))
    print(arr)
    arr.sort(key=lambda x:x[0])
    print(arr)
    arr.sort(key=lambda x:x[1])
    print(arr)
    answer = 1
    e = arr[0][1]
    for i in range(1, len(arr)):
        temp_s, temp_e = arr[i][0], arr[i][1]
        if temp_s >= e:
            answer += 1
            e = temp_e
    print(answer)

if __name__ == "__main__":
    main()