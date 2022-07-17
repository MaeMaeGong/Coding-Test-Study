## 백준 1904번 연산자 끼워넣기 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1904

### 알고리즘
1. `N`을 1부터 차례대로 직접 나열하면 피보나치 수열임을 알 수 있다.
2. 수열을 만들기 위해서 편의상 `dp[0]`과 `dp[1]`을 1로 초기화해준다.
3. 각 수열 `dp[i]`는 `dp[i-1]`와 `dp[i-2]`을 더하고 15746을 나눠준 값으로 초기화한다.
4. 위의 과정을 2부터 `N`까지 반복한 후에 `dp[N]`을 출력한다.

### 소스코드
```java
import java.io.*;

public class BOJ1904 {
    static int N;
    static long[] dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());

            dp = new long[n+1];
            dp[0] = 1; dp[1] = 1;
            for(int i=2; i<=N; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%15746;
            }

            bw.write((dp[N])+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```