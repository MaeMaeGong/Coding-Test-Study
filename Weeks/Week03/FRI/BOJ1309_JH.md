## 백준 1309번 동물원 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1309

### 알고리즘
1. 사자들이 가로 또는 세로로 붙어있지 않게 배치하려면 경우를 **3가지**로 나눠야 한다.
2. 만약에 `i`번째 우리의 왼쪽에 사자를 배치한다면 `i+1`번째 사자는 오른쪽에만 배치할 수 있다.
3. 반대로 `i`번째 우리의 오른쪽에 사자를 배치한다면 `i+1`번째 사자는 왼쪽에만 배치할 수 있다.
4. 사자를 배치하지 않는 경우도 하나의 경우의 수로 치는 것을 고려해서 `i`번째 우리에 사자를 배치하지 않는다면 `i+1`번째 사자는 왼쪽 또는 오른쪽 모두에 배치할 수 있다.
5. 위의 과정을 0번째 우리부터 `N-1`번째 우리까지 반복하면 `2*N` 배열에 사자를 배치하는 경우의 수를 구할 수 있다.

### 소스코드
```java
import java.io.*;

public class BOJ1309 {
    static int N;
    static int[] dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());

            dp = new int[N][3];
            dp[0][0] = dp[0][1] = dp[0][2] = 1; // 0번째 사자를 배치하는 방법에는 3가지가 있다.

            for(int i=1; i<N; i++) {
                dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
                dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
                dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
            }

            bw.write((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])%9901+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```