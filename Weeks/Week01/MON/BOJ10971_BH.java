
//가장 중요한 포인트는 어디서 출발하든 최단 거리는 동일하다는 것.
//그러므로 백트래킹을 통하여 하나의 노드에서 출발하여 자신으로 올 때 까지의 모든 경로를 탐색한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971_BH {

    static int[][] TSP;
    static int N;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        TSP = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                TSP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(2, 2, 0, 0);
        System.out.println(min);
    }

    public static void dfs(int start, int now, int count, int cost) {
        if (start == now && count == N) {
            min = Math.min(min, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (TSP[now][i] > 0) {
                if (i == start && count == N) {
                    cost += TSP[now][i];
                    dfs(start, i, count + 1, cost);
                } else if (!visited[i]) {
                    visited[i] = true;
                    cost += TSP[now][i];
                    dfs(start, i, count + 1, cost);
                    cost -= TSP[now][i];
                    visited[i] = false;
                }
            }
        }
    }
}
