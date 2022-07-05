## 백준 2212번 센서 (골드 5)
### 문제링크
- https://www.acmicpc.net/problem/2212

### 알고리즘
1. 수신 가능영역을 구하기 위해서 입력받은 센서의 좌표를 오름차순으로 정렬한다.
2. `i+1`번째 좌표와 `i`번째 좌표의 차를 통해서 수신 가능영역을 구하고 `diff`에 저장한다.
3. 값이 최대한 작은 원소들로만 `diff`를 합해서 답을 도출해야하기 때문에 `diff`를 오름차순으로 정렬한다.
4. 집중국이 `k`개라면 영역을 `k`개만큼 나눠줘야하기 때문에 `diff`를 `k-1`개만큼 값이 큰 순서대로 제거해줘야 한다.
5. 따라서 0번째부터 `diff.length-(k-1)`번째 전까지의 `diff` 값들을 더한 값이 수신 가능 영역의 길이의 합의 최솟값이다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            if(n <= k) bw.write(0+"\n");
            else {
                int[] arr = new int[n];
                int[] diff = new int[n];

                // 수신 가능영역을 구하기 위해서 센서의 좌표를 오름차순으로 정렬
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0; i<n; i++)
                    arr[i] = Integer.parseInt(st.nextToken());
                Arrays.sort(arr);

                // 수신 가능영역을 구해서 오름차순으로 정렬
                for(int i=0; i<n-1; i++)
                    diff[i] = arr[i+1]-arr[i];
                Arrays.sort(diff);

                // diff의 길이는 n-1이고, k개만큼 영역을 나눠줘야한다.
                // 따라서 k-1개의 diff를 값이 큰 순서대로 제거해줘야한다.
                // 다시 말해서 0번째부터 diff.length-(k-1)번째 전까지의 diff를 더해주면 된다.
                int answer = 0;
                for(int i=0; i<diff.length-(k-1); i++)
                    answer += diff[i];
                bw.write(answer+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```