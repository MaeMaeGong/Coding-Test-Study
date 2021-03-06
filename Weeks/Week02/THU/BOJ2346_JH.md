## 백준 2346번 풍선 터뜨리기 (실버 3)
### 문제링크
- https://www.acmicpc.net/problem/2346

### 알고리즘
1. 풍선의 인덱스와 값을 활용하기 위해서 `Balloon` 클래스를 정의하고 값들을 덱에 각각 추가한다.
2. 덱에서 맨처음 원소를 빼서 정답 출력용 리스트 `answer`에 추가한다.
3. 편의상 맨처음 뻬낸 원소의 값 `answer.get(answer.size()-1).val`을 `val`로 정의한다.
4. 만약에 `val`이 양의 정수라면 `val-1`번만큼 덱의 맨 앞에 있는 원소를 뒤로 뺀다.
5. 만약에 `val`이 음의 정수라면 `val`번만큼 덱의 맨 뒤에 있는 원소를 앞으로 뺀다.
6. 위의 과정을 `n`번만큼 반복하고 덱에 원소가 남아있지 않으면 반복문을 탈출한다.
7. `answer`에 있는 값들을 순서대로 출력하고 종료한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ2346 {
    static class Balloon {
        int idx;
        int val;
        Balloon(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            Deque<Balloon> dq = new ArrayDeque<>();
            List<Balloon> answer = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                dq.add(new Balloon(i, Integer.parseInt(st.nextToken())));
            }

            for(int i=0; i<n; i++) {
                answer.add(dq.pollFirst());
                if(dq.isEmpty()) break; // 덱에 남은 풍선이 없으면 반복문 탈출
                if(answer.get(answer.size()-1).val>0) {
                    for(int j=0; j<answer.get(answer.size()-1).val-1; j++) {
                        dq.addLast(dq.pollFirst());
                    }
                }
                else {
                    for(int j=0; j<Math.abs(answer.get(answer.size()-1).val); j++) {
                        dq.addFirst(dq.pollLast());
                    }
                }
            }

            for(Balloon balloon : answer)
                bw.write(balloon.idx+" ");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```