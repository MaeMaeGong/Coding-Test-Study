import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11060_BH {

    static int[] node;
    static int[] dist;
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        node = new int[1001];
        dist = new int[1001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            node[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0);
        if (cnt == 0) {
            System.out.println("-1");
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == N - 1) {
                System.out.println(dist[now]);
                cnt++;
            }

            if (node[now] != 0) {
                for (int i = 1; i <= node[now]; i++) {
                    if (now + i <= N && dist[now + i] == 0) {
                        dist[now + i] = dist[now] + 1;
                        queue.add(now + i);
                    }
                }
            }
        }
    }
}