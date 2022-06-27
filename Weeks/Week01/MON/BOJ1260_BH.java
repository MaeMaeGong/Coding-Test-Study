// 인접행렬을 통한 기본적인 DFS, BFS 구현 문제
// 재귀를 사용하여 연결된 노드 부터 다시 함수를 호출하면 깊이우선탐색
// 큐를 사용하여 시작 노드에서 연결된 모든 노드를 먼저 탐색할 경우에는 너비우선탐색이다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_BH {

    static int[][] node;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        node = new int[1001][1001];
        visited = new boolean[1001];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = node[y][x] = 1;
        }

        dfs(V);
        // node = new int[1001][1001];
        visited = new boolean[1001];
        System.out.println();
        bfs();
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < 1001; i++) {
            if (node[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        visited[V] = true;
        System.out.print(V + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < 1001; i++) {
                if (node[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }

        }
    }
}
