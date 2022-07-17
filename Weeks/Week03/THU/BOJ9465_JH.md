## 백준 9465번 스티커 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/9465

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9465 {
    static int T, N;
    static int[][] arr, dp;
    static List<Integer> list;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            list = new ArrayList<>();

            T = Integer.parseInt(br.readLine());
            for(int t=0; t<T; t++) {
                N = Integer.parseInt(br.readLine());
                arr = new int[N+1][2];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0; i<N; i++) {
                    arr[i][0] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(br.readLine());
                for(int i=0; i<N; i++) {
                    arr[i][1] = Integer.parseInt(st.nextToken());
                }

                dp = new int[N+1][2];
                dp[0][0] = arr[0][0];
                dp[0][1] = arr[0][1];
                dp[1][0] = arr[1][0] + dp[0][1];
                dp[1][1] = arr[1][1] + dp[0][0];

                for(int i=2; i<N; i++) {
                    dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + arr[i][0];
                    dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + arr[i][1];
                }
                list.add(Math.max(dp[N-1][0], dp[N-1][1]));
            }

            for(int item : list)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```