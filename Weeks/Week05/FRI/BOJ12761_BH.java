import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761_BH {

    static int A, B, N, M;
    static int[] dist;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dist = new int[100001];
        visited = new boolean[100001];
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(answer);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int temp = queue.poll();
            if (temp == M) {
                answer = dist[M];
                return;
            }

            if (temp - A >= 0 && !visited[temp - A]) {
                queue.add(temp - A);
                dist[temp - A] = dist[temp] + 1;
                visited[temp - A] = true;
            }
            if (temp + A <= 100000 && !visited[temp + A]) {
                queue.add(temp + A);
                dist[temp + A] = dist[temp] + 1;
                visited[temp + A] = true;
            }
            if (temp - B >= 0 && !visited[temp - B]) {
                queue.add(temp - B);
                dist[temp - B] = dist[temp] + 1;
                visited[temp - B] = true;
            }
            if (temp + B <= 100000 && !visited[temp + B]) {
                queue.add(temp + B);
                dist[temp + B] = dist[temp] + 1;
                visited[temp + B] = true;
            }
            if (temp + 1 <= 100000 && !visited[temp + 1]) {
                queue.add(temp + 1);
                dist[temp + 1] = dist[temp] + 1;
                visited[temp + 1] = true;
            }
            if (temp - 1 >= 0 && !visited[temp - 1]) {
                queue.add(temp - 1);
                dist[temp - 1] = dist[temp] + 1;
                visited[temp - 1] = true;
            }

            if (temp * A <= 100000 && !visited[temp * A]) {
                queue.add(temp * A);
                dist[temp * A] = dist[temp] + 1;
                visited[temp * A] = true;
            }
            if (temp * B <= 100000 && !visited[temp * B]) {
                queue.add(temp * B);
                dist[temp * B] = dist[temp] + 1;
                visited[temp * B] = true;
            }
        }
    }
}
