import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644_BH {

    static int n, m, per1, per2;
    static int[][] node;
    static boolean[] visited;
    static int count = 0;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        per1 = Integer.parseInt(st.nextToken());
        per2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        node = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x][y] = node[y][x] = 1;
        }
        dfs(per1, 0);

        if (answer != 0) {
            System.out.println(answer);
        } else {
            System.out.println("-1");
        }
    }

    public static void dfs(int start, int count) {
        visited[start] = true;
        if (start == per2) {
            answer = count;
            return;
        } else {
            for (int i = 1; i < n + 1; i++) {
                if (node[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(i, count + 1);
                }
            }
        }
    }
}