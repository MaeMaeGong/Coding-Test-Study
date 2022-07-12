import sys
input = sys.stdin.readline

def main():
    n, m=map(int, input().split())
    arr=list(map(int, input().split()))
    left = 1
    maxx=max(arr)
    right = sum(arr)
    while left <= right:
        mid = (left+right) // 2
        ch = 0
        num = 1
        for i in arr:
            if (ch + i) <= mid:
                ch += i
            else:
                num += 1
                ch = i
        if mid>=maxx and num <= m:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
    print(answer)    


if __name__ == "__main__":
    main()



# import sys
# input = sys.stdin.readline

# def Count(a, capacity):
#     cnt=1
#     sum=0
#     for x in a:
#         if sum+x>capacity:
#             cnt+=1
#             sum = x
#         else:
#             sum+=x
#     return cnt

# n, m=map(int, input().split())
# a=list(map(int, input().split()))
# maxx=max(a)
# lt=1
# rt=sum(a)
# res=0
# while lt<=rt:
#     mid=(lt+rt)//2
#     if mid>=maxx and Count(a, mid)<=m:
#         res=mid
#         rt=mid-1
#     else:
#         lt=mid+1
# print(res)