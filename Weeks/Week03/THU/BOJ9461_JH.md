## 백준 9461번 파도반 수열 (실버 3)
### 문제링크
- https://www.acmicpc.net/problem/9461

### 알고리즘
1. `N`을 1부터 차례대로 직접 나열하면 `i-2`번째 값과 `i-3`번째 값을 더해서 만들어지는 수열임을 알 수 있다.
2. 위의 수열을 만들기 위해서 편의상 `dp[0]`, `dp[1]`, `dp[2]`, `dp[3]`을 1로 초기화해준다.
3. 위의 과정을 각 테스트케이스에 대해서 4부터 `N`까지 반복한 후에 리스트에 `dp[N]`을 추가한다.
4. 최종적으로 리스트에 추가된 값들을 순서대로 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T, N;
    static long dp;
    static List<Long> list;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            list = new ArrayList<>();

            T = Integer.parseInt(br.readLine());
            for(int t=0; t<T; t++) {
                N = Integer.parseInt(br.readLine());
                dp = new long[N+3];
                dp[0] = 1; dp[1] = 1;
                dp[2] = 1; dp[3] = 1;
                for(int i=4; i<=N; i++)
                    dp[i] = dp[i-2] + dp[i-3];
                list.add(dp[N]);
            }

            for(long item : list)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```