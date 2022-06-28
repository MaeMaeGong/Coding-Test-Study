## 백준 1697번 숨바꼭질 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1697

### 알고리즘
1. `N`에서 BFS를 시작한다.
2. 가장 빨리 찾은 시간을 게산하기 위해서 `idx`와 `time`을 원소로 가지는 `Node` 클래스를 생성한다.
3. 총 3가지의 행동 `X-1`, `X+1`, `X*2`을 할 수 있으므로 각각의 경우에 대해서 이동할 수 있는지 확인한 후에 방문 처리 및 `time`을 1 증가시켜서 큐에 넣어준다.
4. 큐에서 꺼낸 `node.idx`의 값이 `K`와 일치하면 `answer`에 값을 저장하고 반복문을 탈출한다.

### 소스코드
```java
package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K, answer;
    static boolean[] visited;
    static int[] dx = { -1, 1 };
    static class Node {
        int idx;
        int time;
        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static boolean check(int next) {
        return next>=0 && next<=100000 && !visited[next];
    }
    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.idx == K) {
                answer = node.time;
                break;
            }
            for(int i=0; i<3; i++) {
                int next;
                if(i==2) next = node.idx * 2;
                else next = node.idx + dx[i];
                if(check(next)) {
                    q.offer(new Node(next, node.time+1));
                    visited[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[100001];

            bfs(N);

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```