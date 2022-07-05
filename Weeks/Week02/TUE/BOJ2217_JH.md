## 백준 2217번 로프 (실버 4)
### 문제링크
- https://www.acmicpc.net/problem/2217

### 알고리즘
1. 리스트에 저장한 값들을 내림차순으로 정렬한다.
2. 임의의 로프들을 이용하여 들어올릴 수 있는 물체의 중량은 `i`번째 로프에 `i+1`을 나눠준 값이다.
3. 최대 중량을 구하기 위해서 `max`에 리스트의 첫번재 값을 대입하고 `list.get(i) * (i+1)`와 비교해서 값을 갱신한다.
4. 위의 과정을 리스트를 모두 탐색할 때까지 반복한 후에 `max` 값을 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++)
                list.add(Integer.parseInt(br.readLine()));
            Collections.sort(list, Collections.reverseOrder());

            int max = list.get(0);
            for(int i=1; i<list.size(); i++) {
                max = Math.max(max, list.get(i) * (i+1));
            }

            bw.write(max+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```