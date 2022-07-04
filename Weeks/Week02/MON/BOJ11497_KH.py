import sys
input = sys.stdin.readline

def main():
    t = int(input())
    result = []
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().split()))
        arr.sort()
        min_check = 0
        temp = [0 for i in range(n)]
        j = 1
        temp[0] = arr[0]
        if n % 2 == 1:
            for i in range(1, n//2 + 1):
                temp[i * 1] = arr[j]
                j += 1
                temp[i * -1] = arr[j]
                j += 1
        else:
            for i in range(1, n//2):
                temp[i * 1] = arr[j]
                j += 1
                temp[i * -1] = arr[j]
                j += 1
            temp[n//2] = arr[j]
            
        for i in range(n - 1):
            if i == 0:
                min_check = max(min_check, abs(temp[-1] - temp[0]))
            else:
                min_check = max(min_check, abs(temp[i] - temp[i + 1]))
        
        result.append(min_check)
        
    for i in result:
        print(i)
        



if __name__ == "__main__":
    main()