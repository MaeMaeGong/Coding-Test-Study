
//인접행렬을 사용하여 해결한 간단한 bfs 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_BH {

    static int n, m;
    static int[][] virus;
    static boolean[] visited;
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        virus = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            virus[x][y] = virus[y][x] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    public static void bfs(int start) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (virus[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }

        }
    }
}
