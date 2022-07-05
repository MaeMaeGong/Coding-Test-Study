import sys
input = sys.stdin.readline

def main():
    n = int(input())
    arr = list(map(int, input().split()))
    result = 0
    if n > 3:
        
        result = 0
        sum1 = [0 for _ in range(n)]
        sum2 = [0 for _ in range(n)]
        sum1[0] = arr[0]
        sum2[n - 1] = arr[n - 1]
        
        for i in range(1, n):
            sum1[i] = sum1[i - 1] + arr[i]

        for i in range(n - 2, -1, -1):
            sum2[i] = sum2[i + 1] + arr[i]   

         # 벌 - 꿀통 - 벌
        for i in range(1, n):
            result = max(result, sum1[i] - arr[0] + sum2[i] - arr[n - 1])
        
        # 벌 - 벌 - 꿀통
        for i in range(1, n):
            result = max(result, sum1[n - 1] - arr[0] + sum2[i] - arr[i] * 2)

        # 꿀통 - 벌 - 벌
        arr.reverse()
        for i in range(1, n):
            sum1[i] = sum1[i - 1] + arr[i]
        for i in range(n - 2, -1, -1):
            sum2[i] = sum2[i + 1] + arr[i]  
        for i in range(1, n):
            result = max(result, sum1[n - 1] - arr[0] + sum2[i] - arr[i] * 2)
            
    else:
        result = max(arr) * 2
    print(result)



if __name__ == "__main__":
    main()

