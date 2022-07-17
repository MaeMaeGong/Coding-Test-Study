## 백준 1149번 RGB거리 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1149

### 알고리즘
1. 모든 집들을 색칠하기 위한 최소 비용을 구하기 위해서 `i`번째 왼쪽, 가운데, 오른쪽 집까지 칠해지는 최소 비용을 각각 구해야 한다.
2. 예를 들어 `i`번째 왼쪽 집을 칠하기 위한 최소 비용을 구하려면, `i-1`번째 가운데 집까지 칠하기 위한 최소 비용과 `i-1`번째 오른쪽 집까지 칠하기 위한 최소 비용 중에서 최소값과 `i`번째 왼쪽 집을 칠하기 위한 비용을 더해줘야 한다.
3. 3번의 예시처럼 `i`번재 왼쪽 집의 색은 `i-1`번째 왼쪽 집의 색 또는 `i+1`번째 오른쪽 집의 색과 같으면 안된다. 따라서 왼쪽 집을 제외한 **가운데** 집까지 색칠하는 비용과 **오른쪽** 집까지 색칠하는 비용 중에 최소값을 택해서 `i`번째 왼쪽 집의 색칠 비용과 더해준 값이 `dp[i][0]`이다.
4. 2번의 예시와 같이 모든 `i`에 대해서 `i`번째 가운데 집과 `i`번쨰 오른쪽 집을 각각 구해준다.
5. 최종적으로 `dp[N][0]`, `dp[N][1]`, `dp[N][2]` 중에 최소값을 출력하면 된다.

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N+1][3];
            for(int i=1; i<=N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N+1][3];
            for(int i=0; i<3; i++) {
                dp[1][i] = arr[1][i];
            }
            for(int i=2; i<=N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            bw.write(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2])+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```