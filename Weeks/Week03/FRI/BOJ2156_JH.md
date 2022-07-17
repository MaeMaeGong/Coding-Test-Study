## 백준 2156번 포도주 시식 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/2156

### 소스코드
```java
import java.io.*;

public class BOJ2156 {
    static int N;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());

            int[] arr = new int[N+1];
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            if(N==1) bw.write(arr[1]+"\n");
            else if(N==2) bw.write((arr[1]+arr[2])+"\n");
            else {
                int[] dp = new int[N+1];
                dp[1] = arr[1];
                dp[2] = arr[1] + arr[2];
                dp[3] = Math.max(Math.max(arr[1], arr[2]) + arr[3], dp[2]);
                for(int i=4; i<=N; i++) {
                    dp[i] = Math.max(Math.max(arr[i-1]+dp[i-3], dp[i-2])+arr[i], dp[i-1]);
                }

                bw.write(dp[N]+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```